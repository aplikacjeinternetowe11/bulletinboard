package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Service.BoardService;
import com.ttuleja.bulletinboard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showIndex(){
        return "index";

    }

    @RequestMapping(value = "/add_item")
    public String addItemPanel(){
        return "add_item";

    }
    @RequestMapping(value = "/add_item",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "item_name",defaultValue = " ") String itemName,
                          @RequestParam(value = "item_description",defaultValue = " ") String itemDescription,
                          @RequestParam(value = "item_price",defaultValue = " ") String itemPrice,
                          @RequestParam(value = "user_name",defaultValue = " ") String userName){

        if(!(itemName.equals(" ")) && !(itemDescription.equals(" ")) && !(itemPrice.equals(" ")) && !(userName.equals(" "))){
            boardService.addItem(itemName, itemDescription, itemPrice, userName);
            String redirectUrl = "/show_items";
            return "redirect:" + redirectUrl;
        }else {
            String redirectUrl = "/add_item";
            return "redirect:" + redirectUrl;
        }
    }

    @RequestMapping(value = "/show_items", method = RequestMethod.GET)
    public String showItems(Model model){

        model.addAttribute("itemList",boardService.showItems());
        return "show_items";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String showSingleItem(@PathVariable("id") int id,Model model){

        model.addAttribute("item_description",boardService.showItemDescription(id));
        model.addAttribute("phone_number",userService.getUserPhoneNumberByItemId(id));


        return "show_single_item";
    }
}
