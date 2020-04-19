package net.fly.order.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author zchjeff on 2017/11/1.
 */
public class WafRequestWrapper extends HttpServletRequestWrapper {
    private boolean filterXSS = true;
    private boolean filterSQL = true;

    public WafRequestWrapper(HttpServletRequest request, boolean filterXSS, boolean filterSQL) {
        super(request);
        this.filterXSS = filterXSS;
        this.filterSQL = filterSQL;
    }

    public WafRequestWrapper(HttpServletRequest request) {
        this(request, true, true);
    }
}
