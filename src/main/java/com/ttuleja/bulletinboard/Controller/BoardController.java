package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Entity.File;
import com.ttuleja.bulletinboard.Service.BoardService;
import com.ttuleja.bulletinboard.Service.ImageService;
import com.ttuleja.bulletinboard.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ServletContext context;


    @RequestMapping(value = "/")
    public String showIndex(){
        return "index";

    }

    @RequestMapping(value = "/add_item")
    public String addItemPanel(){
        String relativeWebPath = "/";
        String upload_dir = context.getRealPath(relativeWebPath);
        System.out.println(upload_dir);
        return "add_item";

    }
    @RequestMapping(value = "/add_item",method = RequestMethod.POST)
    public String addItem(@RequestParam(value = "item_name",defaultValue = " ") String itemName,
                          @RequestParam(value = "item_description",defaultValue = " ") String itemDescription,
                          @RequestParam(value = "item_price",defaultValue = " ") String itemPrice,
                          @RequestParam(value = "user_name",defaultValue = " ") String userName,
                          @ModelAttribute File form, ModelMap model, HttpSession session){

        // private static String upload_dir = "/static/";
        String relativeWebPath = "/";
        String upload_dir = context.getRealPath(relativeWebPath);
        System.out.println(upload_dir);

        Pattern pricePattern= Pattern.compile("[0-9]*");


        if(pricePattern.matcher(itemPrice).matches() && !(itemName.equals(" ")) && !(itemDescription.equals(" ")) && !(itemPrice.equals(" ")) && !(userName.equals(" "))){
            boardService.addItem(itemName, itemDescription, itemPrice, userName);

            int maxItemId = boardService.getMaxItemId();
            ArrayList<String> fileNames = null;
            if(form.getAlbums().length>0) {
                fileNames = new ArrayList<String>();
                int i = 1;
                for(MultipartFile file:form.getAlbums()) {

                    try {
                        String imageName = maxItemId + "_" + i + ".jpg";
                        file.transferTo(new java.io.File(upload_dir + imageName));
                        i++;
                        fileNames.add(file.getOriginalFilename());
                        imageService.addImageNameToDatabase(imageName,maxItemId);

                        //imageService.addImageNames();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


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

        String id1 = Integer.toString(id);
        model.addAttribute("image_names",imageService.getImageName(id1));

        String relativeWebPath = "/";
        String upload_dir = context.getRealPath(relativeWebPath);
        model.addAttribute("directory",upload_dir);



        return "show_single_item";
    }
}
