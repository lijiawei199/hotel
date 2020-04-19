package net.fly.order.api.model.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-20 17:59
 * <p>
 * Company: 恒堃
 * <p>
 *
 * @author hengkun
 * @version 1.0.0
 **/
@ApiModel("登陆用户信息响应")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    @ApiModelProperty("管理员名称")
    private String adminName;

    @ApiModelProperty("管理员工号")
    private String staffid;

    @ApiModelProperty("管理员手机号")
    private String mobile;

    @ApiModelProperty("管理员归属")
    private String userType;
}
