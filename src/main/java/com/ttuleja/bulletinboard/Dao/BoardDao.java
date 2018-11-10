package com.ttuleja.bulletinboard.Dao;

import com.ttuleja.bulletinboard.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addItem(String itemName, String itemDescription, String itemPrice, String userName) {
        String sql = "INSERT INTO item (item_name,item_description,item_price,user_name) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{itemName,itemDescription,itemPrice,userName});

    }

    public Collection<Item> showItems() {
        String sql = "SELECT * FROM item";
        Collection<Item> items;
        items = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Item.class));
        return items;

    }

    public Item showItemDescription(int id) {
        String sql = "SELECT item_id,user_name,item_name,item_description,date,item_price FROM item WHERE item_id=?";
        Item item1;
        item1 = (Item) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Item.class),id);
        return item1;
    }
}
