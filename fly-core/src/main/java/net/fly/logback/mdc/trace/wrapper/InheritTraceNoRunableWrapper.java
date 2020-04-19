package net.fly.logback.mdc.trace.wrapper;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:42
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class InheritTraceNoRunableWrapper implements Runnable {

    private Runnable inner;
    private String traceNo;

    public InheritTraceNoRunableWrapper(Runnable inner) {
        this.inner = inner;
        this.traceNo = TraceNoUtils.getTraceNo();
    }

    public void run() {
        if (this.traceNo == null) {
            TraceNoUtils.newTraceNo();
        } else {
            TraceNoUtils.newTraceNo(this.traceNo);
        }

        try {
            this.inner.run();
        } finally {
            TraceNoUtils.clearTraceNo();
        }

    }
}
