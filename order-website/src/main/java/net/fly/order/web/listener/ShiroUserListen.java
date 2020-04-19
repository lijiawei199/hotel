package net.fly.order.web.listener;

import lombok.extern.slf4j.Slf4j;
import net.fly.order.api.model.shiro.bean.ShiroUser;
import net.fly.order.core.util.HttpKit;
import net.fly.order.core.util.ShiroKit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-08-30 17:27
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Slf4j
public class ShiroUserListen extends HttpServlet implements HttpSessionListener {

    // mobile - session
    public static final Map<String, HttpSession> USER_SESSION = new HashMap<>();
    // jsessionid - mobile
    public static final Map<String, String> SESSION_USER = new HashMap<>();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String jsessionid = se.getSession().getId();
        log.info("{} login", jsessionid);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String jsessionid = se.getSession().getId();
        log.info("{}退出，清空sessionid", jsessionid);
        USER_SESSION.remove(SESSION_USER.remove(jsessionid));
    }

    /**
     * 后登录的用户会覆盖上一次登录的用户
     *
     * @param shiroUser
     */
    public static void userLoginHandler(ShiroUser shiroUser) {
        /**
         * 踢除原有登录信息
         */
        HttpSession oriSession = USER_SESSION.get(shiroUser.getMobile());
        if (oriSession != null) {
            try {
                ShiroUser oriUser = (ShiroUser) oriSession.getAttribute("shiroUser");
                if (oriUser != null) {
                    ShiroKit.removeFixUser(oriSession.getId());
                    USER_SESSION.get(SESSION_USER.get(oriUser.getJsessionid())).invalidate();
                    SESSION_USER.remove(oriUser.getJsessionid());
                    USER_SESSION.remove(shiroUser.getMobile());
                }
            } catch (Exception e) {
                log.error("orig {} not logininfo", shiroUser.getMobile());
            }
        }
        // 处理当前登录用户
        HttpSession session = HttpKit.getRequest().getSession();
        SESSION_USER.put(shiroUser.getJsessionid(), shiroUser.getMobile());
        USER_SESSION.put(shiroUser.getMobile(), session);
    }
}
