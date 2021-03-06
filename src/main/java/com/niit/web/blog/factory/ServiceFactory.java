package com.niit.web.blog.factory;

import com.niit.web.blog.service.*;
import com.niit.web.blog.service.impl.*;

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

    public static ArticleService getArticleServiceInstance(){
        return new ArticleServiceImpl();
    }

    public static TopicService getTopicServiceInstance(){
        return new TopicServiceImpl();
    }
}
