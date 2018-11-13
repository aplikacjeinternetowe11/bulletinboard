package com.ttuleja.bulletinboard.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addRating(int ratingNumber, String ratingAuthor, String ratingTarget) {
        String sql1 = "DELETE FROM rating WHERE rating_author=? AND rating_target=?";
        jdbcTemplate.update(sql1,ratingAuthor,ratingTarget);


        String sql2 = "INSERT INTO rating (rating_number,rating_author,rating_target) VALUES (?,?,?)";
        jdbcTemplate.update(sql2, new Object[]{ratingNumber,ratingAuthor,ratingTarget});

    }

    public String getUserRating(String userName) {
        String sql = "SELECT round(avg(rating_number),2) FROM rating WHERE rating_target=?";
        String userRating;
        userRating = jdbcTemplate.queryForObject(sql, new Object[]{userName}, String.class);

        return userRating;
    }
}
