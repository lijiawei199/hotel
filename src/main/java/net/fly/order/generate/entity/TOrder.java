package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户订单表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 订单编号
            */
    private String orderCode;

            /**
            * 酒店ID
            */
    private Long hotelId;

            /**
            * 产品编号
            */
    private String prodCode;

            /**
            * 单价ID
            */
    private Long priceId;

            /**
            * 支付金额
            */
    private BigDecimal amount;

            /**
            * 用户ID
            */
    private Long userId;

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
