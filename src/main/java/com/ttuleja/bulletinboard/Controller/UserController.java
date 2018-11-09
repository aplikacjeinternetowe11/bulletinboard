package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerUserPanel(){

        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "username", defaultValue = " ") String username,
                               @RequestParam(value = "password", defaultValue = " ") String password,
                               @RequestParam(value = "phone_number", defaultValue = " ") String phone_number){

        String redirectUrl = "/";

        userService.addUser(username,password,phone_number);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginUserPanel(){
        return "login";
    }
    @RequestMapping(value = "test_dostepu",method = RequestMethod.GET)
    public String testDostepu(){
        return "index";
    }
}
