package com.ttuleja.bulletinboard.Entity;

public class Image {
    private int image_id;
    private String image_name;
    private int item_id;

    public Image(int image_id, String image_name, int item_id) {
        this.image_id = image_id;
        this.image_name = image_name;
        this.item_id = item_id;
    }

    public Image(){

    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
