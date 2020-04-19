package net.fly.order.generate.entity;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 酒店单价表
    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class THotelPrice implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 酒店ID
            */
    private Long hotelId;

            /**
            * 单价
            */
    private BigDecimal price;

            /**
            * 单价说明
            */
    private String priceDesc;

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
