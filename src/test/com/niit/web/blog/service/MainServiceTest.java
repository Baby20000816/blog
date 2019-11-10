package com.niit.web.blog.service;

import com.niit.web.blog.domain.MainDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class MainServiceTest {
private MainService mainService = ServiceFactory.getMainServiceInstance();
    @Test
    public void signIn() {
        MainDto mainDto = new MainDto("13980320536", "a86b3e0c385fcf80e0ec0b5f0473d3");
        Map<String, Object> map = mainService.signIn(mainDto);
        System.out.println(map);
    }
}