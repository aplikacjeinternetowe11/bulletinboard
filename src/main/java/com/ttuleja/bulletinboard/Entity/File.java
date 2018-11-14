package com.ttuleja.bulletinboard.Entity;

import org.springframework.web.multipart.MultipartFile;

public class File {

    private MultipartFile [] albums;

    public MultipartFile[] getAlbums() {
        return albums;
    }
    public void setAlbums(MultipartFile[] albums) {
        this.albums = albums;
    }

}
