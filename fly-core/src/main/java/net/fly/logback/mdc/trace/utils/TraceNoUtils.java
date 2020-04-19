package net.fly.logback.mdc.trace.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:41
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoUtils {

    public static void newTraceNo() {
        MDC.put("traceNo", RandomStringUtils.randomAlphanumeric(12));
    }

    public static void newTraceNo(String parentTranceNo) {
        if (StringUtils.isNotEmpty(parentTranceNo)) {
            MDC.put("traceNo", parentTranceNo + "-" + RandomStringUtils.randomAlphanumeric(6));
        } else {
            newTraceNo();
        }

    }

    public static String getTraceNo() {
        return MDC.get("traceNo");
    }

    public static void clearTraceNo() {
        MDC.remove("traceNo");
    }
}
