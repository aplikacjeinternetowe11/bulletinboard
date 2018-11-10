package com.ttuleja.bulletinboard.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String username, String password, String phone_number) {
        String sql = "INSERT INTO user (user_name,user_password,phone_number) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{username,password,phone_number});

    }

    public String getUserPhoneNumberByItemId(int id) {
        String sql1 = "SELECT user_name FROM item WHERE item_id=?";
        String userName;
        userName = jdbcTemplate.queryForObject(sql1,new Object[]{id}, String.class);
        String sql2 = "SELECT phone_number FROM user WHERE user_name=?";
        String phoneNumber;
        phoneNumber = jdbcTemplate.queryForObject(sql2, new Object[]{userName}, String.class);
        return phoneNumber;
    }
}
