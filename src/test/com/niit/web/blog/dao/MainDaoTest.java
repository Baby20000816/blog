package com.niit.web.blog.dao;


import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.DaoFactory;

import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);


 /*   public void insert() {
        long n = 0;
        User user = new User();
        user.setMobile("13811112222");
        user.setPassword("123");
        try {
            n = userDao.getUserById(user);
        } catch (SQLException e) {
            logger.error("新增用户出现异常");
        }
        assertEquals(1, n);
    }*/

    @Test
    public void batchInsert() {
        int[] n = new int[0];
        try {
            n = userDao.batchInsert(JSoupSpider.getUsers());
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void findUserByMobile() {
        User user = null;
        try {
            user = userDao.findUserByMobile("13979913096");
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        assertNotNull(user);
    }
}