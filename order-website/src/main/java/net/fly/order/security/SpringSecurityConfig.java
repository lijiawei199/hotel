package net.fly.order.security;

import net.fly.order.authentication.*;
import net.fly.order.authentication.*;
import net.fly.order.service.admin.impl.AdminDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:20
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
//@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // 未登陆时返回 JSON 格式的数据给前端（否则为 html）
    @Resource
    private MyAuthenticationEntryPoint authenticationEntryPoint;

    // 登录成功返回的 JSON 格式数据给前端（否则为 html）
    @Resource
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;

    //  登录失败返回的 JSON 格式数据给前端（否则为 html）
    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    // 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
    @Resource
    private MyLogoutSuccessHandler logoutSuccessHandler;

    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
    @Resource
    private MyAccessDeniedHandler accessDeniedHandler;

    // 自定义user
    @Resource
    private AdminDetailsService userDetailsService;

    // 拦截器
    @Resource
    private MyAuthenticationTokenFilter myAuthenticationTokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",//swagger api json
                "/swagger-resources/configuration/ui",//用来获取支持的动作
                "/swagger-resources",//用来获取api-docs的URI
                "/swagger-resources/configuration/security",//安全选项
                "/swagger-ui.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.cors().and()

                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .anyRequest()
                .access("@rbacauthorityservice.hasPermission(request, authentication)") // RBAC 动态 url 认证

                .and()
                .formLogin()  //开启登录
                .successHandler(authenticationSuccessHandler) // 登录成功
                .failureHandler(authenticationFailureHandler) // 登录失败
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问 JSON 格式的数据
        http.addFilterBefore(myAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class); // JWT Filter

    }
}
