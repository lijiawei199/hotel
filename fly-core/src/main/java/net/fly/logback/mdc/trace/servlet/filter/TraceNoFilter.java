package net.fly.logback.mdc.trace.servlet.filter;

import net.fly.logback.mdc.trace.utils.TraceNoUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-27 21:40
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class TraceNoFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        TraceNoUtils.newTraceNo();

        try {
            chain.doFilter(request, response);
        } finally {
            TraceNoUtils.clearTraceNo();
        }

    }

    public void destroy() {
    }
}
