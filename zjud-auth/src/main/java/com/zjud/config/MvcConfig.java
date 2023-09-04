package com.zjud.config;

import com.zjud.interceptor.AuthInterceptor;
import com.zjud.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/27 13:48
 * @description
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] swaggerPaths = {"/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**", "/doc.html/**", "/v3/**"};

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/register")
                .excludePathPatterns("/notice/latest")
                .excludePathPatterns(swaggerPaths)
                .order(0);

        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**/admin/**")
                .order(1);
    }


}
