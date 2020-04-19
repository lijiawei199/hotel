package net.fly.order;

import lombok.extern.slf4j.Slf4j;
import net.fly.logback.mdc.trace.servlet.filter.TraceNoFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fly
 */
@Slf4j
@EnableCaching
@MapperScan("net.fly.order.mapper*")
@SpringBootApplication
@EnableSwagger2
public class OrderApplication extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean filterReg() {
        FilterRegistrationBean reg = new FilterRegistrationBean(new TraceNoFilter());
        reg.addUrlPatterns("/*");
        return reg;
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        log.info("====================================================");
        log.info("==========  Order-Adm-Api Start Success ==========");
        log.info("====================================================");
    }
}
