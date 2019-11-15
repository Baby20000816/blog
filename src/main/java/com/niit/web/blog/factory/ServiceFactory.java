package com.niit.web.blog.factory;

import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.service.MainService;
import com.niit.web.blog.service.StudentService;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.service.impl.ArticleServiceImpl;
import com.niit.web.blog.service.impl.MainServiceImpl;
import com.niit.web.blog.service.impl.StudentServiceImpl;
import com.niit.web.blog.service.impl.UserServiceImpl;

/**
 * @author jh_wu
 * @ClassName ServiceFactory
 * @Description TODO
 * @Date 2019/11/5:16:17
 * @Version 1.0
 **/
public class ServiceFactory {
        public static UserService getUserServiceInstance() {
            return new UserServiceImpl();
        }

        public static ArticleService getArticleServiceInstance() {
            return new ArticleServiceImpl();
        }

    public static MainService getMainServiceInstance() {
        return new MainServiceImpl();
    }

    public static StudentService getStudentServiceInstance() {
        return new StudentServiceImpl();
    }
}
