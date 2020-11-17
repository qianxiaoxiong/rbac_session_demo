package com.hangyi.interceptor;

import com.hangyi.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //读取会话信息
        Object userDto = request.getSession().getAttribute(UserDto.SESSIONID_KEY);
        if (userDto == null) {
           writeResponse(response,"请登录");
        }
        UserDto  user =(UserDto)userDto;
        //请求url
        String requestURI = request.getRequestURI();
        if( user.getAuthorities().contains("p1") && requestURI.equals("/login/r/r1")){
            return  true;
        }
        if( user.getAuthorities().contains("p2") && requestURI.equals("/login/r/r2")){
            return  true;
        }
            writeResponse(response,"权限不足，拒绝访问");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    //响应输出
    private  void writeResponse(HttpServletResponse response,String msg)throws  Exception{
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();

    }
}
