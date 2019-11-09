package com.niit.web.blog.service;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13980320536", "a86b3e0c385fcf80e0ec0b5f0473d3");
        Map<String, Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}