package net.fly.api.enums;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 20:54
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public enum ApiRetState {

    SUCCESS("S", "成功"),
    FAILED("F", "失败"),
    PROCESS("P", "处理中");

    private final String code;
    private final String desc;

    private ApiRetState(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ApiRetState getByCode(String code) {
        ApiRetState[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ApiRetState o = var2[var4];
            if (o.getCode().equals(code)) {
                return o;
            }
        }

        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
