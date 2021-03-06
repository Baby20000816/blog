package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;

import java.util.Map;

/**
 * @author mq_xu
 * @ClassName UserService
 * @Description 用户业务逻辑层
 * @Date 12:01 2019/11/9
 * @Version 1.0
 **/
public interface MainService {
    /**
     * 用户登录功能
     * @param userDto
     * @return
     */
    Map<String,Object> signIn(UserDto userDto);
}
