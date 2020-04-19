package net.fly.order.core.util;

import java.nio.charset.StandardCharsets;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-4-25 17:12
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 */
public class ByteUtil {

    /**
     * 判断传进来的字符串，是否
     * 大于指定的字节，如果大于递归调用
     * 直到小于指定字节数 ，一定要指定字符编码，因为各个系统字符编码都不一样，字节数也不一样
     *
     * @param s   原始字符串
     * @param num 传进来指定字节数
     * @return String 截取后的字符串
     */
    public static String idgui(String s, int num) throws Exception {
        int changdu = s.getBytes(StandardCharsets.UTF_8).length;
        if (changdu > num) {
            s = s.substring(0, s.length() - 1);
            s = idgui(s, num);
        }
        return s;
    }
}
