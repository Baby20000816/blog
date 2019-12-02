package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;


import java.util.Map;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13905087288", "ee59cb064f5832707debf71f26453e85");
        Map<String, Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}