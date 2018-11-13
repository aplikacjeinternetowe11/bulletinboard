package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/rating")
@Controller
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/add_rating",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "rating_number",defaultValue = " ") int ratingNumber,
                          @RequestParam(value = "rating_author",defaultValue = " ") String ratingAuthor,
                          @RequestParam(value = "rating_target",defaultValue = " ") String ratingTarget){

        ratingService.addRating(ratingNumber, ratingAuthor, ratingTarget);

        String redirectUrl = "/user/user_profile/" + ratingTarget;
        return "redirect:" + redirectUrl;
    }

}
