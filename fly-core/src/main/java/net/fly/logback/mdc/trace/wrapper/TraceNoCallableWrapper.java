package net.fly.logback.mdc.trace.wrapper;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;

import java.util.concurrent.Callable;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:43
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoCallableWrapper<V> implements Callable<V> {
    private Callable<V> inner;

    public TraceNoCallableWrapper(Callable<V> inner) {
        this.inner = inner;
    }

    public V call() throws Exception {
        TraceNoUtils.newTraceNo();

        Object var2;
        try {
            var2 = this.inner.call();
        } finally {
            TraceNoUtils.clearTraceNo();
        }

        return (V) var2;
    }
}
