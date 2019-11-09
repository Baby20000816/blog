package com.niit.web.blog.service;

import com.niit.web.blog.dao.StudentDao;
import com.niit.web.blog.dao.UserDao;

import com.niit.web.blog.entity.Student;
import com.niit.web.blog.entity.User;

import java.util.List;

/**
 * @author jh_wu
 * @ClassName UserService
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface StudentService{
    List<Student> listStudent();
}
