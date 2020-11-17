package com.hangyi.config;

import com.hangyi.dto.UserDto;

public interface AuthenticationService {

    //认证服务
    UserDto authentication(AuthenticationRequest  authenticationRequest);
}
