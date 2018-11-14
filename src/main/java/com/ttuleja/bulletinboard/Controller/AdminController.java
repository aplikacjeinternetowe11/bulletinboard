package com.ttuleja.bulletinboard.Controller;

import com.ttuleja.bulletinboard.Entity.Image;
import com.ttuleja.bulletinboard.Service.AdminService;
import com.ttuleja.bulletinboard.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private static String upload_dir = "/static/";

    @Autowired
    private AdminService adminService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/delete/item",method = RequestMethod.POST)
    public String deleteItem(@RequestParam(value = "id",defaultValue = " ") String id){
        if (!(id.equals(" "))) adminService.deleteItem(id);

        List<Image> imageNames;

        if (!(id.equals(" "))) {


            imageNames = (List)imageService.getImageName(id);
            adminService.deleteImage(id);

            for (Image i:imageNames) {
                Path fileToDeletePath = Paths.get(upload_dir + i.getImage_name());
                try {
                    Files.delete(fileToDeletePath);
                }catch(IOException e){
                }
            }
        }



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
