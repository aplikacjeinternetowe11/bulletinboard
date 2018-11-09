package com.ttuleja.bulletinboard.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addItem(String itemName, String itemDescription, String itemPrice, String userName) {
        String sql = "INSERT INTO item (item_name,item_description,item_price,user_name) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{itemName,itemDescription,itemPrice,userName});

    }
}
