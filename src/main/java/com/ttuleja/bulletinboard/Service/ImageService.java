package com.ttuleja.bulletinboard.Service;

import com.ttuleja.bulletinboard.Dao.ImageDao;
import com.ttuleja.bulletinboard.Entity.File;
import com.ttuleja.bulletinboard.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ImageService {
    @Autowired
    private ImageDao imageDao;
    public void addImageLinkToDatabase(String[] imgList, int itemId) {
        System.out.println("test"+imgList[0]);

        imageDao.addImageLinkToDatabase(imgList, itemId);

    }

    public Collection<Image> getImageName(String id) {
        return this.imageDao.getImageName(id);

    }
}
