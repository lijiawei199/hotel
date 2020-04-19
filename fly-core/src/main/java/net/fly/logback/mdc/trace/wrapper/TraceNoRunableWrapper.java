package net.fly.logback.mdc.trace.wrapper;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:44
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoRunableWrapper  implements Runnable {
    private Runnable inner;

    public TraceNoRunableWrapper(Runnable inner) {
        this.inner = inner;
    }

    public void run() {
        TraceNoUtils.newTraceNo();

        try {
            this.inner.run();
        } finally {
            TraceNoUtils.clearTraceNo();
        }

    }
}
