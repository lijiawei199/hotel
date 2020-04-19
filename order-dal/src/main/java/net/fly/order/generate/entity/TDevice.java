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
    * 设备表
    * </p>
*
* @author lijiawei
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TDevice implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 设备编号
            */
    private String deviceCode;

            /**
            * 设备名称
            */
    private String deviceName;

            /**
            * 设备单价
            */
    private BigDecimal devicePrice;

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
