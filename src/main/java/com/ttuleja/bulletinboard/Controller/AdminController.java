package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/delete/item",method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id",defaultValue = " ") String id)
    {
        if (!(id.equals(" "))) adminService.deleteItem(id);

        String redirectUrl = "/show_items";
        return "redirect:" + redirectUrl;

    }
    @RequestMapping(value = "/delete/comment",method = RequestMethod.POST)
    public String deleteComment(@RequestParam(value = "id",defaultValue = " ") String id,
                                @RequestParam(value = "comment_target",defaultValue = " ") String commentTarget)
    {
        if (!(id.equals(" "))) adminService.deleteComment(id);

        String redirectUrl = "/user/user_profile/" + commentTarget + "/comments";
        return "redirect:" + redirectUrl;

    }
}
