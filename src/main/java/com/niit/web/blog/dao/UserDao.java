package com.niit.web.blog.dao;
import com.niit.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName UserDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserDao {
        /**
         * 新增用户
         *
         * @param user
         * @return
         * @throws SQLException
         */
        int insert(User user) throws SQLException;

        /**
         * 批量新增用户
         *
         * @param userList
         * @return int[]
         * @throws SQLException
         */
        int[] batchInsert(List<User> userList) throws SQLException;

        /**
         * 根据手机号查找用户
         *
         * @param mobile
         * @return
         * @throws SQLException
         */
        User findUserByMobile(String mobile) throws SQLException;

        /**
         * 查询热门用户
         *
         * @return
         * @throws SQLException
         */
        List<User> selectHotUsers() throws SQLException;


        /**
         * 查询分页用户
         *
         * @return
         * @throws SQLException
         */
        List<User> selectPageUsers(int currentPage, int pageCount) throws SQLException;

        /**
         * 根据id查询用户详情，包括其他数据
         *
         * @return
         * @throws SQLException
         */
        UserVo getUser(long id) throws SQLException;

}