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
    public class TRoyalty implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

            /**
            * 代理类型
            */
    private String type;

            /**
            * 提成比例
            */
    private Integer ratio;


}
