package com.niit.web.blog.factory;

import com.niit.web.blog.dao.*;
import com.niit.web.blog.dao.impl.*;

/**
 * @author jh_wu
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/11/5:16:03
 * @Version 1.0
 **/
public class DaoFactory {

    /**
     * 返回用户实体类
     * @return
     */
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }

    /**
     * 返回文章实体类
     * @return
     */
    public static ArticleDao getArticleInstance(){
        return new ArticleDaoImpl();
    }

    /**
     * 返回地址实体类
     * @return
     */
    public static AddressDao getAddressInstance() {
        return new AddressDaoImpl();
    }

    /**
     * 返回专题实体类
     * @return
     */
    public static TopicDao getTopicInstance() {
        return new TopicDaoImpl();
    }
}