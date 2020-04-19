package net.fly.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YQH
 * @description:验证字符串是否是yyyy-MM-dd的日期格式
 * @date 2019/10/4 11:43
 * net.fly.order.core.util.valid
 */
public class CheckDateValiadator implements ConstraintValidator<CheckDate, String> {

  @Override
  public void initialize(CheckDate constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    //判断值是否为空
    if(value==null || value.trim().equals(""))
    {
      //为空的时候返回true
      return true;
    }
    //yyyy-MM-dd格式的日期表达式
    Pattern p = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    Matcher m = p.matcher(value);

    //进行格式校验
    return m.matches();
  }
}
