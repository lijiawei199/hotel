package net.fly.order.api.model.shiro.bean;

import lombok.Data;
import net.fly.order.api.enums.LoginTypeEnum;

import java.io.Serializable;
import java.util.Set;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-29 22:08
 * <p>
 * Company: 恒堃
 * <p>
 *
 * @author hengkun
 * @version 1.0.0
 **/
@Data
public class ShiroUser implements Serializable {

    private String jsessionid;

    private Long id;

    /** 是否为超管 */
    private Integer isAdmin;

    /** 手机号 */
    private String mobile;

    /** 员工工号 */
    private String staffid;

    /** 姓名 */
    private String realName;

    /** 管理员节点 */
    private String adminRoute;

    /** 店铺id */
    private Long shopId;

    /** 角色集 */
    private Set<Long> roles;

    /** 权限集 */
    private Set<String> permissions;

    /** 登陆类型 */
    private LoginTypeEnum loginType;

}
