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
    * 用户订单表

    * </p>
*
* @author lijiawei
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
            * 0 
订单生成(待审核) 1 审核通过，待配合同(排单中) 2 逾期未配 3 有人投资(发货中) 4 寄到(装配中) 4 订单结束

            */
    private Integer state;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;

            /**
            * 更新时间
            */
    private LocalDateTime updTime;


}
