package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 资金流水表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TAmountBudget implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 投资人Id
            */
    private Long investId;

            /**
            * 订单号
            */
    private String orderCode;

            /**
            * 收支类型
            */
    private String type;

            /**
            * 金额
            */
    private BigDecimal amount;

            /**
            * 前金额
            */
    private BigDecimal befAmount;

            /**
            * 后金额
            */
    private BigDecimal aftAmount;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;


}
