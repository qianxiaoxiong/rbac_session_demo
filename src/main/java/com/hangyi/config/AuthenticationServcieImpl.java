package com.hangyi.config;

import com.hangyi.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationServcieImpl  implements  AuthenticationService{

    //认证
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest ==null || StringUtils.isEmpty(authenticationRequest.getUserName()) || StringUtils.isEmpty( authenticationRequest.getPassword()) ) {
                throw  new  RuntimeException("账号密码不能为空");
        }
         UserDto  userDto = getUserInfo(authenticationRequest.getUserName());
        if (userDto == null) {
            throw new RuntimeException("查询不到用户！");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("密码错误");
        }

        return userDto;
    }
    //模拟用户查询
    private UserDto getUserInfo(String userName) {
        return userDtos.get(userName);
    }



    //会话信息
    HashMap<String,UserDto> userDtos = new HashMap<String,UserDto>();


    {
        Set<String> authorities1 = new HashSet<>();
                authorities1.add("p1");
        Set<String> authorities2 = new HashSet<>();
                authorities2.add("p2");
       userDtos.put("zhangsan",new UserDto("1010","zhangsan","123","zhangsan","110",authorities1));
       userDtos.put("lisi",new UserDto("1011","lisi","123","lisi","112",authorities2));
   }



}
