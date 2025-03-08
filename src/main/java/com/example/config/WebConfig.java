package com.example.config;

import com.example.interceptor.DemoInterceptor;
import com.example.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //封装了component注解
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /*
        注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)//注册拦截器
                .addPathPatterns("/**")         //拦截所有路径，/*表示拦截一级路径，/**表示拦截任意级路径
                .excludePathPatterns("/login"); //放行路径
    }
}
