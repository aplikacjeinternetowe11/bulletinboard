package com.ttuleja.bulletinboard.Entity;

public class Item {
    private int item_id;
    private String user_name;
    private String item_name;
    private String item_description;
    private String date;
    private int item_price;

    public Item(int item_id, String user_name, String item_name, String item_description, String date, int item_price) {
        this.item_id = item_id;
        this.user_name = user_name;
        this.item_name = item_name;
        this.item_description = item_description;
        this.date = date;
        this.item_price = item_price;
    }

    public Item(){

    }
    public int getItem_id() {
        return item_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public String getDate() {
        return date;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }
}
