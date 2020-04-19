package net.fly.order.core.exception;


import net.fly.order.api.enums.ResponseCode;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/3/7 14:10
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public abstract class BaseException extends RuntimeException {

    /**
     * 模块名
     *
     * @return
     */
    public abstract String getModuleName();

    protected String code;

    protected BaseException(String code, String msg, Throwable t) {
        super(msg, t);
        this.code = code;
    }


    protected BaseException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    protected BaseException(ResponseCode responseCode) {
        this(responseCode.code, responseCode.desc);
    }

    protected BaseException(ResponseCode responseCode, Throwable t) {
        this(responseCode.code, responseCode.desc, t);
    }

    public String getCode() {
        return code;
    }
}
