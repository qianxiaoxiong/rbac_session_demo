package com.hangyi.config;


import lombok.Data;

//认证请求结构
@Data
public class AuthenticationRequest {

    private String userName;
    private String password;


}
