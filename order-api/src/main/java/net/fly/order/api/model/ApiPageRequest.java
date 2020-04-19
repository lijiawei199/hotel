package net.fly.order.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/2/13 17:36
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Data
public class ApiPageRequest {

    @ApiModelProperty(value = "页码", example = "1")
    protected long page;

    @ApiModelProperty(value = "分页大小", example = "10")
    protected long pageSize;

}
