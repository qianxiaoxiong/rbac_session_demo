package com.hangyi.controller;

import com.hangyi.config.AuthenticationRequest;
import com.hangyi.config.AuthenticationService;
import com.hangyi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("login")
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("")
    public  String  login(AuthenticationRequest request, HttpSession httpSession){
        UserDto userDto = authenticationService.authentication(request);
        //保存session
        httpSession.setAttribute(UserDto.SESSIONID_KEY, userDto);
        //只能从后端显示，如果不设置就等同于不关闭后台一直都有
//        httpSession.setMaxInactiveInterval(1800);
        return  userDto.getFullname()+"登陆成功";

    }

    @GetMapping("/logout")

    public String logout(HttpSession httpSession){
        UserDto  userDto  = (UserDto) httpSession.getAttribute(UserDto.SESSIONID_KEY);
        System.out.println("userDto = " + userDto);
        httpSession.invalidate();//session 失效
//        UserDto  userDto2  = (UserDto) httpSession.getAttribute(UserDto.SESSIONID_KEY);
//        System.out.println("userDto2 = " + userDto2);
        return "登出成功";

    }

    @GetMapping(value = "r/r1",produces = {"text/plain;charset=UTF-8"})
    public String authorization(HttpSession httpSession){
        UserDto  userDto  = (UserDto) httpSession.getAttribute(UserDto.SESSIONID_KEY);
        String fullname =null;
        if (userDto != null) {
            fullname = userDto.getFullname();
        }else {
            fullname = "匿名";
        }
        return   fullname +" 访问成功";

    }

    @GetMapping(value = "r/r2",produces = {"text/plain;charset=UTF-8"})
    public String authorization2(HttpSession httpSession){
        UserDto  userDto  = (UserDto) httpSession.getAttribute(UserDto.SESSIONID_KEY);
        String fullname =null;
        if (userDto != null) {
            fullname = userDto.getFullname();
        }else {
            fullname = "匿名";
        }
        return   fullname +" 访问成功";

    }
}
