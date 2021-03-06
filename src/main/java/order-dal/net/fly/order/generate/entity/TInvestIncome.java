package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 投资收益表
    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TInvestIncome implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 投资人ID
            */
    private Long investId;

            /**
            * 订单号
            */
    private String orderCode;

            /**
            * 收益金额
            */
    private BigDecimal income;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;


}
