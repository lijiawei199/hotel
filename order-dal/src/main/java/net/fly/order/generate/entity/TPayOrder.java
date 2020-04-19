package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 支付订单表
    * </p>
*
* @author lijiawei
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TPayOrder implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 支付订单号
            */
    private String payCode;

            /**
            * 用户订单号
            */
    private String orderCode;

            /**
            * 支付金额
            */
    private BigDecimal amount;

            /**
            * 支付流水号
            */
    private String serialNo;

            /**
            * 用户ID
            */
    private Long userId;

            /**
            * 支付类型
            */
    private String payType;

            /**
            * 支付时间
            */
    private LocalDateTime payTime;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;

            /**
            * 状态
            */
    private String state;

            /**
            * 更新时间
            */
    private LocalDateTime updTime;


}
