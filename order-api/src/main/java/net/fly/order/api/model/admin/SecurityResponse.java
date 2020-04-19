package net.fly.order.api.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:06
 * <p>
 * Company: 恒堃
 * <p>
 *
 * @author hengkun
 * @version 1.0.0
 **/
@Data
public class SecurityResponse implements Serializable {

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("消息描述")
    private String msg;

    @ApiModelProperty("结果集")
    private Object result;

    @ApiModelProperty("令牌")
    private String token;
}
