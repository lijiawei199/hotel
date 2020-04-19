package net.fly.order.api;

import net.fly.order.api.enums.ResponseCode;
import net.fly.api.enums.ApiRetState;
import net.fly.api.model.ApiBaseResponse;
import net.fly.api.model.ApiResultResponse;
import net.fly.api.model.ApiResultResponseUtils;
import org.slf4j.helpers.MessageFormatter;

import java.util.Objects;

/**
 * 非分页response构建. <br>
 * 不要丢弃泛型信息.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 16:44
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class ResponseUtils extends ApiResultResponseUtils {

    public static <T> ApiResultResponse<T> fail() {
        return buildErrorResponse(ResponseCode.FAILED.code, ResponseCode.FAILED.desc);
    }

    public static <T> ApiResultResponse<T> fail(String msg) {
        return buildErrorResponse(ResponseCode.FAILED.code, msg);
    }

    public static <T> ApiResultResponse<T> fail(String format, Object... args) {
        if (args == null || args.length == 0) {
            return buildErrorResponse(ResponseCode.FAILED.code, format);
        } else {
            return fail(MessageFormatter.arrayFormat(format, args).getMessage());
        }

    }

    public static <T> ApiResultResponse<T> fail(ResponseCode responseCode) {
        return buildErrorResponse(responseCode.code, responseCode.desc);
    }

    public static <T> ApiResultResponse<T> success() {
        return buildSuccessResponse(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.desc);
    }

    public static <T> ApiResultResponse<T> success(T data) {
        return new ApiResultResponse<>(ApiRetState.SUCCESS, data, ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.desc);
    }

    public static boolean checkSuccess(ApiBaseResponse response) {
        return Objects.equals(response.getRetCode(), ResponseCode.SUCCESS.code);
    }

}
