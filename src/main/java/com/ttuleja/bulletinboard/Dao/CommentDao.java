package com.ttuleja.bulletinboard.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addComment(String commentContent, String commentTarget, String userName) {
        String sql = "INSERT INTO comment (comment_author,comment_content,comment_target) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{userName,commentContent,commentTarget});

    }
}
