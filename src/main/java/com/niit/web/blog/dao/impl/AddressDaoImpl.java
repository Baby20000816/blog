package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.AddressDao;
import com.niit.web.blog.entity.Address;
import com.niit.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);

    @Override
    public int[] batchInsert(List<Address> addressList) throws SQLException {

        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_address(address) VALUES (?)";
        connection.setAutoCommit(false);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        addressList.forEach(address -> {
            try {
                pstmt.setString(1,address.getAddress());
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("地址批量添加错误");
            }

        });
        int [] n = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null,pstmt,connection);
        return n;
    }
}