package net.fly.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2020-04-08 09:39
 * <p>
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Data
@TableName("t_banner")
@NoArgsConstructor
@AllArgsConstructor
public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片URL
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 跳转URL
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 状态
     */
    private String state;

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
