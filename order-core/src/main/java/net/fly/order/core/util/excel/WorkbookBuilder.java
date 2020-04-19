package net.fly.order.core.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 14:42
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class WorkbookBuilder {

    private static Workbook initWorkbook(boolean useXSSF) {
        return useXSSF ? new XSSFWorkbook() : new HSSFWorkbook();
    }

    public static Workbook build(boolean useXSSF, SheetBuilder... sheetBuilders) {
        Assert.notNull(sheetBuilders, "sheet页不能为空");
        Workbook workbook = initWorkbook(useXSSF);
        Arrays.stream(sheetBuilders).forEach(e -> e.build(workbook, useXSSF));
        return workbook;
    }

    public static Workbook build(SheetBuilder... sheetBuilders) {
        return build(true, sheetBuilders);
    }

}
