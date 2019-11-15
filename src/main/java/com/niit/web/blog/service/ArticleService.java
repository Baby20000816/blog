package com.niit.web.blog.service;

import com.niit.web.blog.dao.StudentDao;
import com.niit.web.blog.dao.UserDao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Student;
import com.niit.web.blog.entity.User;

import java.util.List;

/**
 * @author jh_wu
 * @ClassName ArticleService
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
    public interface ArticleService {
        /**
         * 获取热门文章
         * @return
         */
        List<ArticleVo> getHotArticles();
    }