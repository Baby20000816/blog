package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName ArticleDao
 * @Description TODO
 * @Date 2019/11/14
 * @Version 1.0
 **/
public interface ArticleDao {
    /**
     * 批量新增文章
     *
     * @param articleList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articleList) throws SQLException;

    List<ArticleVo> selectHotArticles() throws SQLException;
}