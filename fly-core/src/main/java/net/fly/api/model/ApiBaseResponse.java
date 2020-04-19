package net.fly.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.fly.api.enums.ApiRetState;

import java.io.Serializable;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 20:59
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Data
public class ApiBaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("接口响应状态")
    private ApiRetState retState;
    @ApiModelProperty("返回结果码")
    private String retCode;
    @ApiModelProperty("返回信息描述")
    private String retMsg;

    public ApiBaseResponse() {
    }

    public ApiBaseResponse(ApiRetState retState) {
        this.retState = retState;
    }

    public ApiBaseResponse(ApiRetState retState, String retMsg) {
        this.retState = retState;
        this.retMsg = retMsg;
    }

    public ApiBaseResponse(ApiRetState retState, String retCode, String retMsg) {
        this.retState = retState;
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
}
