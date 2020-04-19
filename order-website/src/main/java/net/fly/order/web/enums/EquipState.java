package net.fly.order.web.enums;
//设备状态
public enum EquipState {
    NORMAL("正常",0),
    DAMAGE("损坏",1 );

    private String state;
    private Integer code;

    EquipState(String msg, Integer code) {
        this.state = msg;
        this.code = code;
    }

    public String getMsg() {
        return state;
    }

    public void setMsg(String msg) {
        this.state = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
