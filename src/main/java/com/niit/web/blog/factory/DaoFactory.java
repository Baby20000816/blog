package com.niit.web.blog.factory;

import com.niit.web.blog.dao.StudentDao;
import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.dao.impl.StudentDaoImpl;
import com.niit.web.blog.dao.impl.UserDaoImpl;

/**
 * @author jh_wu
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/11/5:16:03
 * @Version 1.0
 **/
public class DaoFactory {
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }

}
