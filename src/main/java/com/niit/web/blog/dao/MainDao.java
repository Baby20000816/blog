package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Main;

import java.sql.SQLException;
import java.util.List;


/**
 * @author jh_wu
 * @ClassName MainDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface MainDao {
    /**
     * 新增用户
     * @param main
     * @return
     * @throws SQLException
     */
    int insert(Main main) throws SQLException;

    /**
     * 批量新增用户
     *
     * @param mainList
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<Main> mainList) throws SQLException;

    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     * @throws SQLException
     */
    Main findMainByMobile(String mobile) throws SQLException;

}