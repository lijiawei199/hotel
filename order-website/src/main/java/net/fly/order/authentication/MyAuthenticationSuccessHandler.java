package net.fly.order.authentication;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.fly.order.api.constant.RedisKey;
import net.fly.order.api.model.admin.LoginResponse;
import net.fly.order.api.model.admin.SecurityResponse;
import net.fly.order.entity.ext.AdminDetails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:10
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Component
@Slf4j
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecurityResponse resp = new SecurityResponse();

        resp.setStatus("200");
        resp.setMsg("Login Success!");

        AdminDetails userDetails = (AdminDetails) authentication.getPrincipal();
        log.info("登陆成功后 user:{}", userDetails.getAdminName());

        LoginResponse login = new LoginResponse(
                userDetails.getAdminName(),
                userDetails.getUsername(),
                "",
                userDetails.getUserType()
        );
        resp.setResult(login);

        // token 保存30分仲
        String token = UUID.randomUUID().toString();

        redisTemplate.opsForValue().set(RedisKey.ADMIN_TOKEN.format(token), userDetails.getUsername(), 1, TimeUnit.DAYS);

        // 取得之前token
        String oldToken = redisTemplate.opsForValue().get(RedisKey.ADMIN_USER_TOKEN.format(login.getStaffid()));
        log.info("取得之前token:{}", oldToken);
        if (StringUtils.isNotBlank(oldToken)) {
            // 以前token存在时，删除以前token
            redisTemplate.delete(RedisKey.ADMIN_TOKEN.format(oldToken));
        }

        redisTemplate.opsForValue().set(RedisKey.ADMIN_USER_TOKEN.format(login.getStaffid()), token);

        resp.setToken(token);
        log.info("登陆成功后 token:{}", token);

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(resp));
    }
}
