package net.fly.order.exception;

import lombok.extern.slf4j.Slf4j;
import net.fly.api.model.ApiBaseResponse;
import net.fly.order.api.ResponseUtils;
import net.fly.order.api.enums.ResponseCode;
import net.fly.order.core.exception.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 16:52
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@RestControllerAdvice
@Slf4j
public class GolableExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ApiBaseResponse handle(BaseException e) {
        log.error("[" + e.getModuleName() + "]异常", e);
        return ResponseUtils.buildErrorResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ApiBaseResponse handle(Exception e) {
        log.error("系统异常", e);
        return ResponseUtils.fail();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ApiBaseResponse handleTypeMismatchException(Exception e) {
        log.error("参数转换异常", e);
        return ResponseUtils.fail(ResponseCode.PARAM_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiBaseResponse handleValidException(MethodArgumentNotValidException e) {
        log.error("参数验证错误");
        String msg = null;
        try {
            BindingResult bindingResult;
            List<ObjectError> objectErrors;
            if (e != null && (bindingResult = e.getBindingResult()) != null && ((objectErrors = bindingResult.getAllErrors()) != null && objectErrors.size() > 0)) {
                msg = objectErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";"));
            }
        } catch (Exception x) {
            log.error("handleValidException err:{}", x);
        }
        if (StringUtils.isBlank(msg)) {
            msg = ResponseCode.PARAM_ERROR.desc;
        }
        log.error("参数验证错误:{}", msg);
        return ResponseUtils.buildErrorResponse(ResponseCode.PARAM_ERROR.code, msg);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ApiBaseResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("调用接口入参转换验证异常", exception);
        return ResponseUtils.fail(ResponseCode.PARAM_ERROR);
    }
}
