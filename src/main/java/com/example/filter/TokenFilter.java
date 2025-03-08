//package com.example.filter;
//
//import com.example.utils.JwtUtils;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class TokenFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        //1.获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //2.判断是否是登录请求
//        if (requestURI.contains("/login")) {
//            log.info("登录，放行");
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        //3.获取token
//        String token = request.getHeader("token");
//
//        //4.判断token是否存在
//        if (token == null || token.isEmpty()) {
//            log.info("token为空");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        //5.校验token
//        try {
//            JwtUtils.parseToken(token);
//        } catch (Exception e) {
//            log.info("非法令牌");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//
//        //放行
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
