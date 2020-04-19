package net.fly.order.authentication;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.fly.api.enums.ApiRetState;
import net.fly.api.model.ApiResultResponse;
import net.fly.order.api.constant.RedisKey;
import net.fly.order.api.enums.ResponseCode;
import net.fly.order.service.admin.impl.AdminDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:17
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Component
@Slf4j
public class MyAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private AdminDetailsService adminDetailsService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        response.setCharacterEncoding("UTF-8");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String authToken = authHeader.substring("Bearer ".length());
            log.info("token:{}", authToken);

            String userName = redisTemplate.opsForValue().get(RedisKey.ADMIN_TOKEN.format(authToken));
            log.info("token对应的userName:{}", userName);

            if (StringUtils.isNotBlank(userName) && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = adminDetailsService.loadUserByUsername(userName);

                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } else {
                // token 过期
                ApiResultResponse resp = new ApiResultResponse(ApiRetState.FAILED, ResponseCode.ADMIN_TOKEN_INVALID.code, ResponseCode.ADMIN_TOKEN_INVALID.desc);
                response.getWriter().write(JSON.toJSONString(resp));
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
