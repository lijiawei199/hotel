package net.fly.order.api.enums;

/**
 * @author by fly
 * on 2018-03-29
 */
public enum ApiResponseCodeEnum {
    //成功
    SUCCESS("000000", "成功"),
    //失败
    FAILED("FFFFFF", "失败"),
    //输入参数有误，请确认后再试
    PARAM_ERROR("000001", "输入参数有误，请确认后再试"),
    //暂无数据
    NO_DATA("000002","暂无数据"),
    //该菜单不存在
    MENU_NO_EXIST("000003","该菜单不存在"),
    //业务异常
    BIZ_ERROR("999999", "业务异常:%s"),
    //权限不足
    FORBIDDEN("403", "权限不足"),
    INVALID_TOKEN("401","无效的token"),
    NO_AUTHENTICATION("401","访问此资源需要完全的身份验证"),

    SYS_USER_PWD_NOTEQ("200001","两次密码输入不一致"),

    SYS_USER_PWD_NOT_T("200002","原密码不正确"),

    SYS_USER_PWD_EQ("200003","新密码不能与旧密码一样");

    private final String code;
    private final String desc;

    ApiResponseCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ApiResponseCodeEnum getByCode(String code) {
        for (ApiResponseCodeEnum o : values()) {
            if (o.getCode().equals(code)) {
                return o;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
