package net.fly.order.config.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.List;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 10:40
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Configuration
@Slf4j
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurerAdapter() {

            private CorsConfiguration buildConfig() {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.addAllowedOrigin("*");
                corsConfiguration.addAllowedHeader("*");
                corsConfiguration.addAllowedMethod("*");
                corsConfiguration.addExposedHeader("Authorization");
                return corsConfiguration;
            }

            @Bean
            public CorsFilter corsFilter() {
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", buildConfig());
                return new CorsFilter(source);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST")
                        .maxAge(3600);
            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                super.configureMessageConverters(converters);
                converters.add(new ByteArrayHttpMessageConverter());
                FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
                FastJsonConfig fastJsonConfig = new FastJsonConfig();
                fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
                fastJsonConfig.setSerializerFeatures(
                        SerializerFeature.WriteNonStringKeyAsString,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteMapNullValue,
                        SerializerFeature.WriteNullStringAsEmpty,
                        SerializerFeature.WriteDateUseDateFormat
                );
                fastConverter.setFastJsonConfig(fastJsonConfig);
                converters.add(fastConverter);
            }
        };
    }

    @Bean
    public Converter<String, Date> stringToDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isBlank(source)) {
                    return null;
                }
                try {
                    return DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss===");
                } catch (Exception e) {
                    log.warn("错误的日期格式:{}", source);
                    return null;
                }
            }
        };
    }
}
