package com.ttuleja.bulletinboard.Service;

import com.ttuleja.bulletinboard.Dao.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingDao ratingDao;

    public void addRating(int ratingNumber, String ratingAuthor, String ratingTarget) {
        ratingDao.addRating(ratingNumber,ratingAuthor,ratingTarget);
    }

    public String getUserRating(String userName) {
        return this.ratingDao.getUserRating(userName);
    }
}
