package net.fly.order.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019/1/28 10:28
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Value("${swagger.show}")
    private boolean swaggerShow=true;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder authorization = new ParameterBuilder();
        authorization
                .name("Authorization").description("登录返回的token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .defaultValue((""))
                .required(false).build();

        List<Parameter> ps = new ArrayList<>();
        ps.add(authorization.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .globalOperationParameters(ps)
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.fly.order"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("食堂项目 管理后台 API")
                .description("powered by 飞越")
                .termsOfServiceUrl("http://order.fly.net/")
                //.contact(contact)
                .version("1.0")
                .build();
    }

}

