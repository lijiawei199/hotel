package net.fly.api.enums;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 20:53
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public enum ApiRetCode {

    SUCCESS("000000"),
    PROCESSING("000001"),
    UNKNOWN("EEEEEE"),
    ILLEGAL_PARAMS("CMM0001"),
    NO_SUPPORT_TYPE("CMM0002"),
    NO_PRODUCT_FUND("CMM0003"),
    NO_MEMBER_FUND("CMM0004"),
    DUPLICATE_ORDER_NO("CMM0005"),
    NO_TRADE_FOUND("CMM0006"),
    BEGIN_GE_END("CMM0007"),
    WITHDRAW_TIMES_ENOUGH("CMM0008"),
    NO_ASSET_FUND("FA0001"),
    ASSET_NOT_ENOUGH("FA0002"),
    DUPLICATE_MEMBER_ASSET("FA0003"),
    MEMBER_NO_CARD("FT0001"),
    LIMIT_FAIL("CMM0009"),
    ILLEGAL_REQUEST("CMM0010"),
    ACCOUNT_NOT_IN("CMM0011"),
    ACCOUNT_NOT_OUT("CMM0012"),
    ILLEGAL_SIGN("CMM0013"),
    EXPIRED("CMM0013"),
    NOT_GRANT("CMM0014"),
    NOT_AUTH("CMM0014");

    private final String code;

    private ApiRetCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
