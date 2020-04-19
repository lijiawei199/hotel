package net.fly.order.api;

import net.fly.order.api.enums.ResponseCode;
import net.fly.order.api.model.ApiPageResponse;
import net.fly.api.enums.ApiRetState;
import org.slf4j.helpers.MessageFormatter;

import java.util.List;

/**
 * 分页response构建. <br>
 * 注意 不要丢弃泛型信息.
 * <p>
 * Copyright: Copyright (c) 2019/3/8 16:56
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class PageResponseUtils {

    public static <T> ApiPageResponse<T> success(List<T> data, Integer total) {
        return new ApiPageResponse<>(data, total);
    }

    public static <T> ApiPageResponse<T> success(List<T> data, long total) {
        return new ApiPageResponse<>(data, (int) total);
    }

    public static <T> ApiPageResponse<T> fail() {
        return fail(ResponseCode.FAILED.code, ResponseCode.FAILED.desc);
    }

    public static <T> ApiPageResponse<T> fail(String msg) {
        return fail(ResponseCode.FAILED.code, msg);
    }

    public static <T> ApiPageResponse<T> fail(String format, Object... args) {
        if (args == null || args.length == 0) {
            return fail(ResponseCode.FAILED.code, format);
        } else {
            return fail(MessageFormatter.arrayFormat(format, args).getMessage());
        }
    }

    public static <T> ApiPageResponse<T> fail(ResponseCode responseCode) {
        return fail(responseCode.code, responseCode.desc);
    }

    public static <T> ApiPageResponse<T> fail(String code, String msg) {
        return buildErrorResponse(code, msg);
    }

    private static <T> ApiPageResponse<T> buildErrorResponse(String code, String msg) {
        return new ApiPageResponse<>(ApiRetState.SUCCESS, code, msg);
    }


}
