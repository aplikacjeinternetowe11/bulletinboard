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
    public void addImageNameToDatabase(String imageName, int maxItemId) {
        imageDao.addImageNameToDatabase(imageName, maxItemId);

    }

    public Collection<Image> getImageName(String id) {
        return this.imageDao.getImageName(id);

    }
}
