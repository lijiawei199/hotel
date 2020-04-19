package net.fly.order.api.enums;

import java.util.Arrays;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 15:58
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public enum ResponseCode {

    /**
     * 响应状态码
     */
    SUCCESS("000000", "成功"),
    PARAM_ERROR("000001", "输入参数有误，请确认后再试"),
    IMPORT_FILE_FAILED("-999998", "导入文件检查出错"),
    FAILED("-999999", "数据获取失败，请稍后再试"),

    ADMIN_NOT_EXIST("000002", "管理员不存在或已禁用"),
    ADMIN_TOKEN_INVALID("000003", "管理员Token已失效"),
    ADMIN_PASSWORD_CHECK_ERROR("000004", "管理员密码校验失败"),
    ADMIN_PASSWORD_INPUT_ERROR("000005", "管理员密码校验失败三次及以上，请过20分钟以后再试"),

    ;

    public final String code;
    public final String desc;

    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResponseCode getByCode(String code) {
        return Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst().orElse(null);
    }
}
