package net.fly.order.api.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/3/21 17:47
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Slf4j
public class JdImgPrefix {

    private static final String MAIN_URL = "http://img13.360buyimg.com/n%s/";

    private static final String CUSTOM_URL = "http://img13.360buyimg.com/n0/s%s_%s_";

    /**
     * n0(最大图 800*800px)、n1(350*350px)、n2(160*160px)、n3(130*130px)、n4(100*100px)
     * @param i
     * @return
     */
    public static String N(int i) {
        if (i < 0 || i > 4) {
            log.warn("非法的默认尺寸:{},", i);
            i = 0;
        }
        return String.format(MAIN_URL, i);
    }

    public static String custom(int x, int y) {
        return String.format(CUSTOM_URL, x, y);
    }


}
