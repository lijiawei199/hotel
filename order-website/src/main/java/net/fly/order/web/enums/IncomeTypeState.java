package net.fly.order.web.enums;
//收入类型启用或关闭？
public enum IncomeTypeState {
    OPEN("启用", 0),
    CLOSE("关闭", 1);


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    IncomeTypeState(String msg, Integer state) {
        this.state = state;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Integer state;
    private String msg;
}
