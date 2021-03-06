package net.fly.logback.mdc.trace.layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:39
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoPatternLayout extends PatternLayout {

    public String doLayout(ILoggingEvent event) {
        String s = super.doLayout(event);
        String traceNo = (String)event.getMDCPropertyMap().get("traceNo");
        if (s != null && event.getThrowableProxy() != null && traceNo != null) {
            if (s.endsWith("\n")) {
                s = StringUtils.replace(s.substring(0, s.length() - 1), "\n", "\n[" + traceNo + "]\t") + "\n";
            } else {
                s = StringUtils.replace(s, "\n", "\n[" + traceNo + "]\t");
            }
        }

        return s;
    }
}
