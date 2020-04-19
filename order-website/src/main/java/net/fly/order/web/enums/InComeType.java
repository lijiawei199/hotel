package net.fly.order.web.enums;

//收入类型
public enum InComeType {
    SWEEP("扫码收益", 1),
    SALE("销售收益", 2),
    INSTALL("安装收益", 3),
    SIGNING("签约收益", 4);

    private String msg;
    private Integer code;

    InComeType(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
