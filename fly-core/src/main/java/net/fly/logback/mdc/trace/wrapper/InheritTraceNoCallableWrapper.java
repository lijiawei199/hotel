package net.fly.logback.mdc.trace.wrapper;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;

import java.util.concurrent.Callable;

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
public class InheritTraceNoCallableWrapper<V> implements Callable<V> {

    private Callable<V> inner;
    private String traceNo;

    public InheritTraceNoCallableWrapper(Callable<V> inner) {
        this.inner = inner;
        this.traceNo = TraceNoUtils.getTraceNo();
    }

    public V call() throws Exception {
        if (this.traceNo == null) {
            TraceNoUtils.newTraceNo();
        } else {
            TraceNoUtils.newTraceNo(this.traceNo);
        }

        Object var2;
        try {
            var2 = this.inner.call();
        } finally {
            TraceNoUtils.clearTraceNo();
        }

        return (V) var2;
    }
}
