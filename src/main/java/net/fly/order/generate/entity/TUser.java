package net.fly.order.generate.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户编号
            */
    private String userCode;

            /**
            * 昵称
            */
    private String nickName;

            /**
            * 手机号
            */
    private String mobile;

            /**
            * 状态
            */
    private String state;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;

            /**
            * 更新时间
            */
    private LocalDateTime updTime;


}
