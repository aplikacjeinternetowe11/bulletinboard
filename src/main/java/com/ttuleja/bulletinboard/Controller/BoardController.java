package com.ttuleja.bulletinboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping(value = "/")
    public String showIndex(){
        return "index";

    }

}
