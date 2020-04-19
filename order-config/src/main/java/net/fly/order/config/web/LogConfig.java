package net.fly.order.config.web;

import net.fly.logback.mdc.trace.servlet.filter.TraceNoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/3/6 16:41
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Configuration
public class LogConfig {

    @Bean
    public FilterRegistrationBean filterReg() {
        FilterRegistrationBean reg = new FilterRegistrationBean(new TraceNoFilter());
        reg.addUrlPatterns("/*");
        return reg;
    }

}
