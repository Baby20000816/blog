package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13979913096", "d3b77d55332418cef1fb5e0243b0a10f");
        Map<String, Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}