package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author mq_xu
 * @ClassName UserService
 * @Description 用户业务逻辑层
 * @Date 12:01 2019/11/9
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 用户登录功能
     * @param userDto
     * @return
     */
//    登录功能
    Map<String,Object> signIn(UserDto userDto);

    /**
     * 所有用户查询功能
     * @return
     */
    List<User> listUser();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findUserById(long id);
}