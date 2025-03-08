package com.example.interceptor;

import com.example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
    校验JWT令牌
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    /*
        返回true则放行，false则不放行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //1.获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //2.判断是是否是登录请求
//        if(requestURI.contains("/login")){
//            return true;//是登录请求，放行
//        }

        //3.获取token
        String token = request.getHeader("token");

        //4.判断token是否存在，若不存在则说明用户没有登陆
        if (token == null || token.isEmpty() ){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//返回401
            return false;
        }

        //5.token存在，校验token
        try {
            JwtUtils.parseToken(token);
        }catch (Exception e){
            //校验token失败，不放行
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//返回401
            return false;
        }

        return true;
    }

}
