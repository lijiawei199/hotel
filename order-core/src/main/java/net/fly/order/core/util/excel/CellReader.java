package net.fly.order.core.util.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 14:39
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class CellReader {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private ExcelErrors errors;

    public CellReader(ExcelErrors errors) {
        this.errors = errors;
    }

    public String getStringValue(Cell cell) {
        return this.getStringValue(cell, DEFAULT_DATE_FORMAT);
    }

    public String getStringValue(Cell cell, String dateFormat) {
        if (cell == null) {
            return StringUtils.EMPTY;
        }
        switch (cell.getCellTypeEnum()) {
            case _NONE:
                return StringUtils.EMPTY;
            case BLANK:
                return StringUtils.EMPTY;
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    return new SimpleDateFormat(dateFormat).format(date);
                }
                return new BigDecimal(cell.getNumericCellValue()).toString();
            case FORMULA:
                return Objects.toString(cell.getRichStringCellValue(), "");
            default:
                errors.addError(cell.getRowIndex(), cell.getColumnIndex(), "错误的单元格格式");
                return "";
        }
    }

    private static final String ERROR_NUMBER = "值[%s]不是有效的数字类型";
    private static final String ERROR_INTEGER = "值[%s]不是有效的整数类型";

    public BigDecimal getNumberValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case _NONE:
                return null;
            case BLANK:
                return null;
            case STRING:
                try {
                    return new BigDecimal(cell.getStringCellValue());
                } catch (Exception e) {
                    errors.addError(cell.getRowIndex(), cell.getColumnIndex(), String.format(ERROR_NUMBER, cell.getStringCellValue()));
                    return null;
                }
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    String format = new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
                    errors.addError(cell.getRowIndex(), cell.getColumnIndex(), String.format(ERROR_NUMBER, format));
                    return null;
                }
                return new BigDecimal(cell.getNumericCellValue());
            case FORMULA:
                try {
                    return new BigDecimal(cell.getNumericCellValue());
                } catch (Exception e) {
                    errors.addError(cell.getRowIndex(), cell.getColumnIndex(), String.format(ERROR_NUMBER, Objects.toString(cell.getRichStringCellValue(), "")));
                    return null;
                }
            default:
                errors.addError(cell.getRowIndex(), cell.getColumnIndex(), "错误的单元格格式");
                return null;
        }
    }



    public Integer getIntegerValue(Cell cell) {
        BigDecimal value = getNumberValue(cell);
        if (value == null) {
            return null;
        }
        if (value.compareTo(new BigDecimal(value.intValue())) != 0) {
            errors.addError(cell.getRowIndex(), cell.getColumnIndex(), String.format(ERROR_INTEGER, cell.getStringCellValue()));
            return null;
        }
        return value.intValue();
    }

    public Long getLongValue(Cell cell) {
        BigDecimal value = getNumberValue(cell);
        if (value == null) {
            return null;
        }
        if (value.compareTo(new BigDecimal(value.longValue())) != 0) {
            errors.addError(cell.getRowIndex(), cell.getColumnIndex(), String.format(ERROR_INTEGER, cell.getStringCellValue()));
            return null;
        }
        return value.longValue();
    }
}
