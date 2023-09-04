package com.zjud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/28 10:42
 * @description swagger配置类
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private Boolean enable = true;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .apiInfo(new ApiInfoBuilder()
                        .title("XXX平台")
                        .description("XXX平台描述")
                        // .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("knife", "https://knife.blog.csdn.net/", "914135534@qq.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("all")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.zjud.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
