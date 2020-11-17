package com.hangyi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

//当前登录用户信息
@Data
@AllArgsConstructor
public class UserDto {

    //定义一个SESSIONID_KEY 作为session中存放用户信息
    public static final String SESSIONID_KEY = "_user";

    private  String id;
    private  String userName;
    private  String password;
    private  String fullname;
    private  String mobile;

    //上面是获取会话信息

    //下面是获取authoriza权限资源

    Set<String> authorities;


}
