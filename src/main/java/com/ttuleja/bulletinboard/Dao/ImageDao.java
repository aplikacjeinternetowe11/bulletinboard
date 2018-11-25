package com.ttuleja.bulletinboard.Dao;

import com.ttuleja.bulletinboard.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ImageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addImageLinkToDatabase(String[] imgList, int itemId) {
        String sql = "INSERT INTO image (image_name,item_id) VALUES (?,?)";
        System.out.println("test"+imgList[0]);
        for(int i=1;i<imgList.length;i++) {
            System.out.println("test:" + imgList[i]);
            jdbcTemplate.update(sql, new Object[]{imgList[i], itemId});
        }
    }

    public Collection<Image> getImageName(String id) {

        String sql = "SELECT * FROM image WHERE item_id=?";
        Collection<Image> imageNames;
        imageNames = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Image.class),id);

        return imageNames;
    }
}
