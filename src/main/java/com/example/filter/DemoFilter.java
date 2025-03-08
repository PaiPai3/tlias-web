//package com.example.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/*")
//@Slf4j
//public class DemoFilter implements Filter {
//    //web服务器启动时候执行一次
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    //拦截到请求之后执行，执行多次
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("发生拦截");
//    }
//
//    //web服务器关闭时候执行一次
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
