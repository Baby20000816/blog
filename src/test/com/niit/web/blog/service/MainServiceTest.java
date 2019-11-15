package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

public class MainServiceTest {
private MainService mainService = ServiceFactory.getMainServiceInstance();
    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13980320536", "a86b3e0c385fcf80e0ec0b5f0473d3");
        Map<String, Object> map = mainService.signIn(userDto);
        System.out.println(map);
    }
}