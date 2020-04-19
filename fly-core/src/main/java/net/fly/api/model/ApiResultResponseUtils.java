package net.fly.api.model;

import net.fly.api.enums.ApiRetState;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:01
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class ApiResultResponseUtils {

    public ApiResultResponseUtils() {
    }

    public static <T> ApiResultResponse<T> buildSuccess(T t) {
        ApiResultResponse<T> response = new ApiResultResponse(ApiRetState.SUCCESS, t);
        return response;
    }

    public static <T> ApiResultResponse<T> buildSuccessResponse(String code, String msg) {
        return new ApiResultResponse(ApiRetState.SUCCESS, (Object)null, code, msg);
    }

    public static <T> ApiResultResponse<T> buildErrorResponse(String code, String msg) {
        return new ApiResultResponse(ApiRetState.SUCCESS, code, msg);
    }
}
