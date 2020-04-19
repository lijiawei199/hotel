package net.fly.order.generate.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 设备明细表

    * </p>
*
* @author lijiawei
* @since 2020-04-18
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TDeviceDetail implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 设备编号
            */
    private String deviceCode;

            /**
            * 产品编号
            */
    private String prodCode;

            /**
            * 二维码
            */
    private String deviceQrcode;

            /**
            * 设备名称
            */
    private String deviceType;

            /**
            * 设备颜色
            */
    private String deviceColor;

            /**
            * 状态
            */
    private String state;

            /**
            * 签约状态
            */
    private String signState;

            /**
            * 添加时间
            */
    private LocalDateTime addTime;

            /**
            * 更新时间
            */
    private LocalDateTime updTime;


}
