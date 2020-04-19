package net.fly.order.web.enums;
//军团角色
public enum LegionRole {
    CENTER("总部",-1),
    PROVINCE("省代理", 0),
    MUNICIPAL("市代", 1),
    COUNTY("县代", 2),
    SALE("扩副", 3),
    INVESTOR("奇兵", 4),
    //小兵即普通用户
    COMMON("小兵", 5);
    private String level;
    private Integer code;

    LegionRole(String msg, Integer code) {
        this.level = msg;
        this.code = code;
    }

    public String getMsg() {
        return level;
    }

    public void setMsg(String msg) {
        this.level = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
