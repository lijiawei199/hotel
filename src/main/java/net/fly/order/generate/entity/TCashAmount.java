package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 提现表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TCashAmount implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 提现订单号
            */
    private String orderCode;

            /**
            * 投资人id
            */
    private Long investId;

            /**
            * 提现金额
            */
    private BigDecimal amount;

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
