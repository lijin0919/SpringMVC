package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class HelloDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User getUser(){
        User user = new User();
        this.jdbcTemplate.query("SELECT * FROM user_info WHERE id=2;", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserPassword(resultSet.getString("user_password"));
            }
        });
        return user;
    }
}
