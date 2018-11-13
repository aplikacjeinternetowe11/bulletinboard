package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.RatingService;
import com.ttuleja.bulletinboard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerUserPanel(){

        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "username", defaultValue = " ") String username,
                               @RequestParam(value = "password", defaultValue = " ") String password,
                               @RequestParam(value = "phone_number", defaultValue = " ") String phone_number){

        if(!(username.equals(" ")) && !(password.equals(" ")) && !(phone_number.equals(" "))){
            userService.addUser(username,password,phone_number);
            String redirectUrl = "/";
            return "redirect:" + redirectUrl;
        }else {
            String redirectUrl = "/user/register";
            return "redirect:" + redirectUrl;
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginUserPanel(){
        return "login";
    }

    @RequestMapping(value = "/user_profile/{user_name}",method = RequestMethod.GET)
    public String showUserProfile(@PathVariable("user_name") String userName, Model model){
        model.addAttribute("user_details",userService.getUserDetails(userName));
        model.addAttribute("average_rating",ratingService.getUserRating(userName));

        return "show_user_profile";
    }
    @RequestMapping(value = "/user_profile/{user_name}/items",method = RequestMethod.GET)
    public String showUserItems(@PathVariable("user_name") String userName, Model model){
        model.addAttribute("user_items",userService.getUserItems(userName));
        model.addAttribute("user_name",userName);

        return "show_user_items";
    }

    @RequestMapping(value = "/user_profile/{user_name}/comments",method = RequestMethod.GET)
    public String showUserComments(@PathVariable("user_name") String userName, Model model){
        model.addAttribute("user_comments",userService.getUserComments(userName));
        model.addAttribute("user_name",userName);
        return "show_user_comments";
    }
}
