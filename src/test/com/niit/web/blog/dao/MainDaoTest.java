package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Main;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MainDaoTest {
    private MainDao mainDao = DaoFactory.getMainDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(MainDaoTest.class);

    @Test
    public void insert() {
        int n = 0;
        Main main = new Main();
        main.setMobile("13811112222");
        main.setPassword("123");
        try {
            n = mainDao.insert(main);
        } catch (SQLException e) {
            logger.error("新增用户出现异常");
        }
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() {
        try { int[] n = mainDao.batchInsert(JSoupSpider.getMain());
            if (n.length!=0)
            {
                logger.info("成功");
            }
            else{
                logger.error("失败");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void findMainByMobile() {
        Main main = null;
        try {
            main = mainDao.findMainByMobile("13979913096");
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        assertNotNull(main);
    }
}