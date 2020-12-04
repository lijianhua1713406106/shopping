package com.offcn.shop.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.shop.bean.User;
import com.offcn.shop.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2020/11/24 0024.
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int zhuCe(User user) {

        String sql = "insert into shop values(null,?,?,?,?,?,?)";


       int result= jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getEmial(),user.getName(),user.getSex(),user.getBirthday());
        return result;
    }

    @Override
    public User findUser(String username, String password) {

        String sql ="select userid,username,password,email,name,sex,birthday from shop where username=? and password=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                user.setEmial(resultSet.getString("email"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setId(resultSet.getInt("userid"));
                return user;
            }
        }, username, password);



    }
}
