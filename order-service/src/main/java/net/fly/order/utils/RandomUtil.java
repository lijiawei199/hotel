package net.fly.order.utils;

import net.fly.order.core.util.DateUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-03-29 15:19
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class RandomUtil {

    /**
     * 取得随机数
     *
     * @param randomNum 随机位数
     * @return 随机数
     */
    public static String random(int randomNum) {

        String uuId = UUID.randomUUID().toString();
        uuId = uuId.replaceAll("-", "");

        if (uuId.length() < randomNum) {
            return uuId.toUpperCase();
        }

        return uuId.substring(0, randomNum).toUpperCase();
    }

    /**
     * 生成唯一流水号 时间戳 + 随机生成6位
     *
     * @return 唯一流水号
     */
    public static String getSerialNumber() {

        StringBuilder serialNum = new StringBuilder();
        serialNum.append(DateUtils.format(new Date(), "yyyyMMddHHmmssSSS"));

        Random random = new Random();
        for (int i = 1; i <= 3; i++) {
            serialNum .append(random.nextInt(10));
        }
        return serialNum.toString();
    }


}
