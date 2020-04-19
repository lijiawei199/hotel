package net.fly.api.model;

import io.swagger.annotations.ApiModelProperty;
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
public class ApiResultResponse<T> extends ApiBaseResponse {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "apiResut",
            notes = "接口响应结果对象"
    )
    private T apiResult;

    public ApiResultResponse() {
    }

    public ApiResultResponse(ApiRetState retState) {
        super(retState);
    }

    public ApiResultResponse(ApiRetState retState, T apiResult) {
        super(retState);
        this.apiResult = apiResult;
    }

    public ApiResultResponse(ApiRetState retState, String retCode, String retMsg) {
        super(retState, retCode, retMsg);
    }

    public ApiResultResponse(ApiRetState retState, T apiResult, String retCode, String retMsg) {
        super(retState, retCode, retMsg);
        this.apiResult = apiResult;
    }

    public T getApiResult() {
        return this.apiResult;
    }

    public void setApiResult(T apiResult) {
        this.apiResult = apiResult;
    }
}
