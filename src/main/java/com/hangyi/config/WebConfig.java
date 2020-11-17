package com.hangyi.config;

import com.hangyi.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/login/r/**");
    }
}
