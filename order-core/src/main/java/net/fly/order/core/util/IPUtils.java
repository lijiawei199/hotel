package net.fly.order.core.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 14:15
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class IPUtils {

    private static final String[] HEADERS = new String[]{"X-Real-IP", "x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP"};
    private static final Pattern LOCALHOST = Pattern.compile("127\\.0\\.0\\.\\d");

    public static String getIpAddr(HttpServletRequest request) {
        String ip = Arrays.stream(HEADERS)
                .map(request::getHeader)
                .filter(e -> StringUtils.isNotBlank(e) && "unknown".equalsIgnoreCase(e))
                .findFirst().orElse(request.getRemoteAddr());
        if (StringUtils.isNotBlank(ip) && ip.contains(",")) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }


}
