package net.fly.order.api;


import net.fly.order.api.enums.ApiResponseCodeEnum;
import net.fly.api.enums.ApiRetState;
import net.fly.api.model.ApiResultResponse;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2018-03-29 下午8:54
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author wangpinzhuang@126.com
 * @version 1.0.0
 **/
public class AppResponseUtils {

    /**
     * 构建响应成功的消息，含结果体
     *
     * @param t 响应消息体
     */
    public static <T> ApiResultResponse<T> buildSuccessResponse(T t) {
        return new ApiResultResponse<T>(ApiRetState.SUCCESS, t, ApiResponseCodeEnum.SUCCESS.getCode(), ApiResponseCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 成功响应，不含结果体
     */
    public static <T> ApiResultResponse<T> buildSuccessResponse() {
        return new ApiResultResponse<>(ApiRetState.SUCCESS, null, ApiResponseCodeEnum.SUCCESS.getCode(), ApiResponseCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 直接构建失败结果体
     */
    public static <T> ApiResultResponse<T> buildErrorResponse() {
        return new ApiResultResponse<>(ApiRetState.SUCCESS, ApiResponseCodeEnum.FAILED.getCode(), ApiResponseCodeEnum.FAILED.getDesc());
    }

    /**
     * 构建响应错误消息，不含结果体
     */
    public static <T> ApiResultResponse<T> buildErrorResponse(ApiResponseCodeEnum retCodeEnum) {
        return new ApiResultResponse<T>(ApiRetState.SUCCESS, retCodeEnum.getCode(), retCodeEnum.getDesc());
    }

    /**
     * 自定义消息
     */
    public static <T> ApiResultResponse<T> buildErrorResponse(String msg) {
        return new ApiResultResponse<>(ApiRetState.SUCCESS, ApiResponseCodeEnum.FAILED.getCode(), msg);
    }

    /**
     * 构建响应错误消息，自定义错误消息
     */
    public static <T> ApiResultResponse<T> buildErrorResponse(ApiResponseCodeEnum retCodeEnum, String msg) {
        return new ApiResultResponse<>(ApiRetState.SUCCESS, retCodeEnum.getCode(), msg);
    }

    /**
     * 构建包含结果体的错误消息
     */
    public static <T> ApiResultResponse<T> buildErrorResponse(T t, ApiResponseCodeEnum retCodeEnum, String msg) {
        return new ApiResultResponse<T>(ApiRetState.SUCCESS, t, retCodeEnum.getCode(), msg);
    }
}
