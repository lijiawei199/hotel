package net.fly.order.core.util;

import java.util.Random;

/**
 * @author YQH
 * @description:
 * @date 2019/9/6 17:43
 * net.fly.order.core.util
 */
public class StringUtil {

  /**
   * 生成随机的四位数字或者字母
   * @param cnt 生成的位数
   * @return
   */
  public static String genRandomNum(int cnt){
    int  maxNum = 36;
    int i;
    int count = 0;
    char[] str = { 'A', 'B', '1', '2', '3','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        'L', 'M', 'N', 'O', 'P', 'Q', 'R','4', '5', '6', 'S', 'T', 'U', 'V', 'W',
        'X', 'Y', 'Z', '0',   '7', '8', '9' };
    StringBuffer pwd = new StringBuffer("");
    Random r = new Random();
    while(count < cnt){
      i = Math.abs(r.nextInt(maxNum));
      if (i >= 0 && i < str.length) {
        pwd.append(str[i]);
        count ++;
      }
    }
    return pwd.toString();
  }

  public static void main(String[] args) {
    System.out.println(StringUtil.genRandomNum(4));
  }

}
