package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 投资-设备-关联表
    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TInvestProd implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 投资人id
            */
    private Long investId;

            /**
            * 设备产品编号
            */
    private String prodCode;

            /**
            * 投资金额
            */
    private BigDecimal investAmount;

            /**
            * 收益比例
            */
    private BigDecimal income;

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
