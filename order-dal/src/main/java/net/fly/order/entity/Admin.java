package net.fly.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台管理表

 * </p>
 *
 * @author hengkun
 * @since 2019-08-28
 */
@TableName("t_admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 店铺id
     */
    @TableField("shop_id")
    private Long shopId;

    /**
     * 管理员名
     */
    @TableField("admin_name")
    private String adminName;

    /**
     * 管理员手机号
     */
    private String mobile;

    /**
     * 员工工号
     */
    private String staffid;

    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 状态
     */
    private String state;

    /**
     * 是否是顶级超管   0-普通，1-顶级管理员（不可删除）
     */
    @TableField("is_admin")
    private Integer isAdmin;

    /**
     * 管理层级
     */
    @TableField("admin_route")
    private String adminRoute;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private Date addTime;
    /**
     * 更新时间
     */
    @TableField("upd_time")
    private Date updTime;

}
