package net.fly.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author YQH
 * @description:判断是否已莫哥字符串开头
 * @date 2019/10/4 11:43
 * net.fly.order.core.util.valid
 */
public class StartWithValiadator implements ConstraintValidator<StartWith, String> {

  private String start;
  @Override
  public void initialize(StartWith constraintAnnotation) {
    this.start = constraintAnnotation.start();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    //判断值是否为空
    if(value==null || value.trim().equals(""))
    {
      //为空的时候返回true
      return true;
    }
    //否则进行格式校验
    return value.startsWith(start);
  }
}
