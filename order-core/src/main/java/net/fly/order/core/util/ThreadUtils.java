package net.fly.order.core.util;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 说明 . <br>
 * 异步线程执行工具类
 * <p>
 * Copyright: Copyright (c) 2017/11/6 10:50
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author lixiaohu
 * @version 1.0.0
 */
public class ThreadUtils {

    private static final Logger log = LoggerFactory.getLogger(ThreadUtils.class);

    private static ThreadUtils thread = new ThreadUtils();

    /**
     * 线程池核心线程数
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(30);

    /**
     * 线程延迟执行时间：毫秒
     */
    private static Integer DELAY = 5;

    public static ThreadUtils me() {
        if (null == thread) {
            return new ThreadUtils();
        }
        return thread;
    }

    /**
     * 执行异步线程
     */
    public void execute(Runnable task) {
        final String taskName = task.getClass().getName();
        log.info("异步线程执行 name: {}", taskName);
        final String traceNo = TraceNoUtils.getTraceNo();
        Runnable traceTask = () -> {
            TraceNoUtils.newTraceNo(traceNo);
            try {
                task.run();
            } catch (Exception e) {
                log.info("异步线程执行 name: " + taskName + "出现异常", e);
            }
        };
        executor.schedule(traceTask, DELAY, TimeUnit.MILLISECONDS);
    }
}
