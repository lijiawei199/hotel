package net.fly.order.core.util.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 14:37
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Col {

    /**
     * 列标题
     * @return
     */
    String name();

    /**
     * 排序值 表格中列顺序排序的依据
     * @return
     */
    int index();

    /**
     * 列宽 不大于0时采用默认列宽
     * @return
     */
    int columWidth() default 0;

    /**
     * 日期格式  仅在字段为 {@link java.util.Date}时有效
     * @return
     */
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";

    /**
     * 批注信息
     * @return
     */
    String comment() default "";
}
