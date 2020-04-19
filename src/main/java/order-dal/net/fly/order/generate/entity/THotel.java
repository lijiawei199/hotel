package net.fly.order.generate.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 酒店表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class THotel implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 酒店名称
            */
    private String hotelName;

            /**
            * 省
            */
    private String prov;

            /**
            * 市
            */
    private String city;

            /**
            * 区
            */
    private String area;

            /**
            * 地址
            */
    private String address;

            /**
            * 联系电话
            */
    private String linkPhone;

            /**
            * 联系人
            */
    private String linkName;

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
