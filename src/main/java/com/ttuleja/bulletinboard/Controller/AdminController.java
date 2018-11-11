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
}
