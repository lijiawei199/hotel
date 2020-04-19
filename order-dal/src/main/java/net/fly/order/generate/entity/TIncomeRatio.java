package net.fly.order.generate.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author lijiawei
* @since 2020-04-19
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TIncomeRatio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 1 扫码 2销售 3 安装 4 签约
            */
    private Integer type;

            /**
            * 0 奇兵 1 酒店 2 扩副 3 招兵师
            */
    private Integer role;

            /**
            * 按百分比存储 如 10% 存10 
            */
    private Integer ratio;

            /**
            * 0 开启 1 关闭
            */
    private Integer state;


}
