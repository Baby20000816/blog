package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.MainDao;
import com.niit.web.blog.entity.Main;
import com.niit.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName MainDaoImpl
 * @Description TODO
 * @Date 2019/11/9:20:11
 * @Version 1.0
 **/
public class MainDaoImpl implements MainDao {
    @Override
    public int insert(Main main) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_jianshu (mobile,password) VALUES (?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, main.getMobile());
        pstmt.setString(2, main.getPassword());
        int n = pstmt.executeUpdate();
        DbUtil.close(null, pstmt, connection);
        return n;
    }

    @Override
    public int[] batchInsert(List<Main> mainList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_jianshu (mobile,password,author,title,introduction,avatar,diamond,comments,fans,create_time) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        mainList.forEach(main -> {
            try {
                pstmt.setString(1, main.getMobile());
                pstmt.setString(2, main.getPassword());
                pstmt.setString(3, main.getAuthor());
                pstmt.setString(4, main.getTitle());
                pstmt.setString(5, main.getIntroduction());
                pstmt.setString(6, main.getAvatar());
                pstmt.setString(7, main.getDiamond());
                pstmt.setString(8, main.getComments());
                pstmt.setString(9, main.getFans());
                pstmt.setObject(10, main.getCreateTime());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //执行批处理操作
        int[] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null, pstmt, connection);
        return result;
    }

    @Override
    public Main findMainByMobile(String mobile) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_jianshu WHERE mobile = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mobile);
        ResultSet rs = pstmt.executeQuery();
        Main main = null;
        if (rs.next()) {
            main = new Main();
            main.setId(rs.getLong("id"));
            main.setMobile(rs.getString("mobile"));
            main.setPassword(rs.getString("password"));
            main.setAuthor(rs.getString("author"));
            main.setTitle(rs.getString("title"));
            main.setIntroduction(rs.getString("introduction"));
            main.setAvatar(rs.getString("avatar"));
            main.setIntroduction(rs.getString("introduction"));
            main.setAvatar(rs.getString("avatar"));
            main.setDiamond(rs.getString("diamond"));
            main.setComments(rs.getString("comments"));
            main.setFans(rs.getString("fans"));
            main.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
        }
        return main;
    }
}
