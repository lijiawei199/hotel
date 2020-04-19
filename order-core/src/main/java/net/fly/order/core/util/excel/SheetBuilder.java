package net.fly.order.core.util.excel;

import lombok.extern.slf4j.Slf4j;
import net.fly.order.core.util.excel.annotation.Col;
import net.fly.order.core.util.excel.annotation.ExcelSheet;
import net.fly.order.core.util.excel.model.SheetModel;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 14:41
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Slf4j
public class SheetBuilder<T extends SheetModel> {

    private Class<?> modelClazz;
    private List<T> sheetData;
    private String firstTitle;
    private int titleRow;
    private boolean autoSizeColumn = false;

    private int[] titleFontSize = {16, 11};

    private int columWidth = 16;

    private Workbook workbook;

    private boolean useXSSF;

    private BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();

    public SheetBuilder(Class<T> clazz, List<T> sheetData) {
        this.modelClazz = clazz;
        this.sheetData = Optional.ofNullable(sheetData).orElse(new ArrayList<>());
    }


    /**
     * 一级标题
     *
     * @param firstTitle 一级标题
     * @param titleRow   一级标题行数
     * @return
     */
    public SheetBuilder<T> firstTitle(String firstTitle, int titleRow) {
        if (titleRow < 1) {
            throw new IllegalArgumentException("titleRow can not less than 1");
        }
        this.firstTitle = firstTitle;
        this.titleRow = titleRow;
        return this;
    }

    /**
     * 标题字体大小
     *
     * @param first  一级标题字体大小
     * @param second 二级标题字体大小
     * @return
     */
    public SheetBuilder<T> titleSize(int first, int second) {
        this.titleFontSize[0] = first;
        this.titleFontSize[1] = second;
        return this;
    }

    /**
     * 列宽
     *
     * @param columWidth
     * @return
     */
    public SheetBuilder<T> columWidth(int columWidth) {
        this.columWidth = columWidth;
        return this;
    }

    /**
     * 自动设置列宽 自动列宽模式将覆盖自定义列宽
     *
     * @param autoSizeColumn
     * @return
     * @deprecated 对中文支持不好 待修复
     */
    @Deprecated
    public SheetBuilder<T> autoSizeColumn(boolean autoSizeColumn) {
        this.autoSizeColumn = autoSizeColumn;
        return this;
    }


    private void registerDateConvert(String dateFormat) {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern(dateFormat);
        beanUtilsBean.getConvertUtils().register(dateConverter, String.class);
    }

    private static final Converter DEFAULT_STRING = new StringConverter(StringUtils.EMPTY);

    private void deregister() {
        beanUtilsBean.getConvertUtils().register(DEFAULT_STRING, String.class);
    }

    private String getSheetName() {
        ExcelSheet sheet = modelClazz.getAnnotation(ExcelSheet.class);
        if (sheet != null && StringUtils.isNotBlank(sheet.name())) {
            return WorkbookUtil.createSafeSheetName(sheet.name());
        } else {
            return "Sheet" + (workbook.getNumberOfSheets() + 1);
        }
    }

    /**
     * 构建workbook
     *
     * @return
     */
    public void build(Workbook workbook, boolean useXSSF) {
        this.workbook = workbook;
        this.useXSSF = useXSSF;
        List<ColInfo> title = Stream.of(modelClazz.getDeclaredFields())
                .map(ColInfo::new)
                .filter(ColInfo::isCol)
                .sorted(Comparator.comparing(ColInfo::getIndex))
                .collect(Collectors.toList());
        Sheet sheet = workbook.createSheet(getSheetName());
        int start = buildTitle(sheet, title);
        int col = title.size();
        int totalRow = sheetData.size();
        for (int i = 0; i < totalRow; i++) {
            Row row = sheet.createRow(i + start);
            SheetModel rowData = sheetData.get(i);
            for (int j = 0; j < col; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(formatCellValue(rowData, title.get(j)));
            }
        }
        setColumWidth(sheet, title);
    }


    private void setColumWidth(Sheet sheet, List<ColInfo> title) {
        if (autoSizeColumn) {
            for (int i = 0; i < title.size(); i++) {
                sheet.autoSizeColumn(i);
            }
        } else {
            if (columWidth > 0) {
                sheet.setDefaultColumnWidth(columWidth);
            }
            for (int i = 0; i < title.size(); i++) {
                ColInfo colInfo = title.get(i);
                if (colInfo.columWidth > 0) {
                    sheet.setColumnWidth(i, colInfo.columWidth);
                }
            }
        }
    }

    private int buildTitle(Sheet sheet, List<ColInfo> title) {
        int currentRow = 0;
        if (StringUtils.isNotBlank(this.firstTitle)) {
            //一级标题 合并单元格
            Row row = sheet.createRow(currentRow);
            Cell cell = row.createCell(0);
            cell.setCellStyle(createStyle(workbook, (short) titleFontSize[0]));
            cell.setCellValue(this.firstTitle);
            currentRow = currentRow + titleRow;
            CellRangeAddress cra = new CellRangeAddress(0, currentRow - 1, 0, title.size() - 1);
            sheet.addMergedRegion(cra);
            RegionUtil.setBorderTop(BorderStyle.THICK, cra, sheet);
        }
        Row row = sheet.createRow(currentRow);
        Drawing drawing = sheet.createDrawingPatriarch();

        //二级标题 字段名
        CellStyle cellStyle = createStyle(workbook, (short) titleFontSize[1]);
        for (int i = 0; i < title.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title.get(i).getName());

            setComment(drawing, cell, title.get(i));
        }
        currentRow++;
        sheet.createFreezePane(0, currentRow, 0, currentRow);
        return currentRow;
    }

    /**
     * 设置批注
     */
    public void setComment(Drawing drawing, Cell cell, ColInfo colInfo) {
        if (StringUtils.isNotBlank(colInfo.getComment())) {
            Comment comment = drawing.createCellComment(useXSSF ? new XSSFClientAnchor() : new HSSFClientAnchor());
            comment.setString(useXSSF ? new XSSFRichTextString(colInfo.getComment()) : new HSSFRichTextString(colInfo.getComment()));
            cell.setCellComment(comment);
        }
    }

    private String formatCellValue(SheetModel rowData, ColInfo colInfo) {
        String value;
        try {
            if (StringUtils.isNotBlank(colInfo.getDateFormat())) {
                registerDateConvert(colInfo.getDateFormat());
            } else {
                deregister();
            }
            value = beanUtilsBean.getProperty(rowData, colInfo.getField());
        } catch (Exception e) {
            log.warn("获取字段异常", e);
            return StringUtils.EMPTY;
        }
        return value;
    }

    private static CellStyle createStyle(Workbook workbook, short fontSize) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        // 创建一个字体样式
        Font font = workbook.createFont();
        font.setFontHeightInPoints(fontSize);
        font.setBold(true);
        style.setFont(font);
        return style;
    }


    private class ColInfo {

        private String name;

        private String dateFormat;

        private String field;

        private int index;

        private int columWidth;

        private boolean isCol;

        private String comment;


        ColInfo(Field field) {
            Col col = field.getAnnotation(Col.class);
            isCol = col != null;
            if (isCol) {
                this.field = field.getName();
                this.name = col.name();
                this.index = col.index();
                this.columWidth = col.columWidth();
                this.comment = col.comment();
                if (field.getType() == Date.class) {
                    this.dateFormat = col.dateFormat();
                } else {
                    this.dateFormat = null;
                }
            }

        }

        boolean isCol() {
            return isCol;
        }

        String getName() {
            return name;
        }

        String getDateFormat() {
            return dateFormat;
        }

        String getField() {
            return field;
        }

        String getComment() {
            return comment;
        }

        int getIndex() {
            return index;
        }
    }
}
