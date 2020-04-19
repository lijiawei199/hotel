package net.fly.order.authentication;

import com.alibaba.fastjson.JSON;
import net.fly.order.api.model.admin.SecurityResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:08
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        SecurityResponse responseBody = new SecurityResponse();

        responseBody.setStatus("000");
        responseBody.setMsg("Need Authorities!");

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(responseBody));
    }
}
