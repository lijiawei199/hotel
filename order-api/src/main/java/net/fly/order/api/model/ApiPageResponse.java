package net.fly.order.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.fly.api.enums.ApiRetState;
import net.fly.api.model.ApiBaseResponse;
import net.fly.order.api.enums.ResponseCode;

import java.util.List;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 16:11
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiPageResponse<T> extends ApiBaseResponse {

    protected int total;
    protected List<T> data;

    public ApiPageResponse(List<T> data, int total) {
        super(ApiRetState.SUCCESS, ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.desc);
        this.data = data;
        this.total = total;
    }

    public ApiPageResponse(ApiRetState retState, String retCode, String retMsg) {
        super(retState, retCode, retMsg);
    }
}
