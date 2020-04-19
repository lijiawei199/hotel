package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 投资人表
    * </p>
*
* @author lijiawei
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TInvest implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
    private Long id;

            /**
            * 姓名
            */
    private String name;

            /**
            * 账号
            */
    private String accountNo;

            /**
            * 职务
            */
    private String investType;

            /**
            * 联系电话
            */
    private String mobile;

            /**
            * 余额
            */
    private BigDecimal amount;

            /**
            * 应收金额
            */
    private BigDecimal totalAmount;

            /**
            * 0损坏1正常
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

            /**
            * 收益比例
            */
    private String earnings;

            /**
            * 保证金
            */
    private BigDecimal bail;

            /**
            * 地址
            */
    private String address;

            /**
            * 身份证
            */
    private String idNumber;

            /**
            * 收益
            */
    private BigDecimal profit;


}
