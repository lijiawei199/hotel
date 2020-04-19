package net.fly.valid;

/**
 * @author YQH
 * @description:验证字符串是否是yyyy-MM-dd的日期格式
 * @date 2019/10/4 11:41
 * net.fly.order.core.util.valid
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {CheckDateValiadator.class})
public @interface CheckDate {
  //提示信息
  String message() default "日期格式必须是yyyy-MM-dd";//通过注解后输出的信息,可以自定义
  Class<?>[] groups() default{};
  Class<?extends Payload>[] payload() default{};
}
