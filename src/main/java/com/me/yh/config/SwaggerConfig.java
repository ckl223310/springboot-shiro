package com.me.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger工具类
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 页面信息显示配置
     *
     * @return
     * @author jia
     * date 2018/8/28
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("权限")
                .version("1.0")
                .build();
    }

    /**
     * swagger配置
     *
     * @return
     * @author jia
     * date 2018/8/28
     **/
    @Bean
    public Docket initDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


}
