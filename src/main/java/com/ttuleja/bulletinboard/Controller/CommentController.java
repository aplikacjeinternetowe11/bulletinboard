package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add_comment",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "comment_content",defaultValue = " ") String commentContent,
                          @RequestParam(value = "comment_target",defaultValue = " ") String commentTarget,
                          @RequestParam(value = "user_name",defaultValue = " ") String userName){

        if(!(commentContent.equals(" ")) && !(commentContent.equals(" ")) && !(userName.equals(" ")) && !(userName.equals(commentTarget))) {
            commentService.addComment(commentContent, commentTarget, userName);
        }
        String redirectUrl = "/user/user_profile/" + commentTarget;
        return "redirect:" + redirectUrl;
    }
}
