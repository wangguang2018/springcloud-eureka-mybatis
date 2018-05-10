package com.wgs.api.config;

import com.wgs.api.interceptor.AccessTokensInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 静态资源路径配置
 * USER: douya
 * DATE: 2017-08-21
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private AccessTokensInterceptor accessTokensInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessTokensInterceptor).addPathPatterns("/**");
    }


}
