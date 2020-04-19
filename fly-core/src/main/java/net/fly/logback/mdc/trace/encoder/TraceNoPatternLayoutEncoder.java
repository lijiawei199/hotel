package net.fly.logback.mdc.trace.encoder;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;
import net.fly.logback.mdc.trace.layout.TraceNoPatternLayout;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:38
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoPatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {

    public void start() {
        PatternLayout patternLayout = new TraceNoPatternLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(this.getPattern());
        patternLayout.start();
        this.layout = patternLayout;
        super.start();
    }
}
