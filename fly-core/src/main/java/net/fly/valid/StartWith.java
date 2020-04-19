package net.fly.valid;

/**
 * @author YQH
 * @description:验证是否已某个字符开头
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
@Constraint(validatedBy = {StartWithValiadator.class})
public @interface StartWith {
  //开头的字符
  String start() default "";

  //提示信息
  String message() default "输入的信息中必须已指定字符开头";//通过注解后输出的信息,可以自定义
  Class<?>[] groups() default{};
  Class<?extends Payload>[] payload() default{};
}
