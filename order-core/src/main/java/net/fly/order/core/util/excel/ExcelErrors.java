package net.fly.order.core.util.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * excel导入校验错误类. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 14:40
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class ExcelErrors {

    /**
     * 错误集合
     */
    private List<Error> errors = new ArrayList<>();

    private class Error {

        private static final String CELL_ERROR = "%s行%s列数据有误：%s";

        private static final String ROW_ERROR = "%s行数据有误：%s";

        /**
         * 错误行号
         */
        private Integer row;
        /**
         * 错误列号
         */
        private Integer col;

        /**
         * 错误信息
         */
        private String msg;

        Error(Integer row, Integer col, String msg) {
            this.row = row;
            this.col = col;
            this.msg = msg;
        }

        Error(Integer row, String msg) {
            this.row = row;
            this.msg = msg;
        }

        @Override
        public String toString() {
            if (col == null) {
                return String.format(ROW_ERROR, row + 1, msg);
            } else {
                return String.format(CELL_ERROR, row + 1, col + 1, msg);
            }
        }
    }

    public void addError(Integer row, Integer col, String msg) {
        errors.add(new Error(row, col, msg));
    }

    public void addError(Integer row, String msg) {
        errors.add(new Error(row, msg));
    }

    public boolean hasError() {
        return errors.size() > 0;
    }

    public String getMsg() {
        if (!hasError()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            errors.forEach(error -> sb.append(error.toString()).append("\n"));
            return sb.toString();
        }
    }
}
