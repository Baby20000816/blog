package com.niit.web.blog.service.impl;


import com.niit.web.blog.dao.MainDao;
import com.niit.web.blog.domain.MainDto;
import com.niit.web.blog.entity.Main;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jh_wu
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2019/11/9:15:45
 * @Version 1.0
 **/
public class MainServiceImpl implements MainService {
    private MainDao mainDao = DaoFactory.getMainDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Override
    public Map<String, Object> signIn(MainDto mainDto) {
        Main main = null;
        Map<String, Object> map = new HashMap<>();
        try {
            main = mainDao.findMainByMobile(mainDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (main != null) {
            if (main.getPassword().equals(mainDto.getPassword())) {
                map.put("msg", "登录成功");
                map.put("data", main);
            } else {
                map.put("msg", "密码错误");
            }
        } else {
            map.put("msg", "手机号不存在");
        }
        return map;
    }

}
