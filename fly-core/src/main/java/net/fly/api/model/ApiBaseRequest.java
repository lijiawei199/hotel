package net.fly.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 20:56
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Data
public class ApiBaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "应用ID", required = true)
    private String appId;

    @ApiModelProperty("扩展参数")
    private String ext;

}
