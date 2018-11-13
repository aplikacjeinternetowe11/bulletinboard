package com.ttuleja.bulletinboard.Dao;

import com.ttuleja.bulletinboard.Entity.Comment;
import com.ttuleja.bulletinboard.Entity.Item;
import com.ttuleja.bulletinboard.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

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

    public User getUserDetails(String userName) {

        String sql = "SELECT user_name,phone_number FROM user WHERE user_name=?";
        User userDetails;
        userDetails = (User) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class),userName);
        return userDetails;
    }

    public Collection<Item> getUserItems(String userName) {
        String sql  = "SELECT * FROM item WHERE user_name=?";
        Collection<Item> userItems;
        userItems = (Collection<Item>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class),userName);
        return userItems;
    }

    public Collection<Comment> getUserComments(String userName) {
        String sql  = "SELECT * FROM comment WHERE comment_target=? ORDER BY comment_date DESC";
        Collection<Comment> userComments;
        userComments = (Collection<Comment>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Comment.class),userName);
        return userComments;

    }

    public boolean checkUserName(String userName) {
        try {
            String sql = "SELECT * FROM user WHERE user_name=?";
            jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(User.class), userName);
        }catch (EmptyResultDataAccessException e){
            return false;
        }
        return true;
    }
}
