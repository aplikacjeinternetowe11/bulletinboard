package com.ttuleja.bulletinboard.Entity;

public class Rating {
    private int rating_id;
    private int rating_number;
    private String rating_author;
    private String rating_target;

    public Rating(int rating_id, int rating_number, String rating_author, String rating_target) {
        this.rating_id = rating_id;
        this.rating_number = rating_number;
        this.rating_author = rating_author;
        this.rating_target = rating_target;
    }

    public Rating(){

    }

    public int getRating_id() {
        return rating_id;
    }

    public void setRating_id(int rating_id) {
        this.rating_id = rating_id;
    }

    public int getRating_number() {
        return rating_number;
    }

    public void setRating_number(int rating_number) {
        this.rating_number = rating_number;
    }

    public String getRating_author() {
        return rating_author;
    }

    public void setRating_author(String rating_author) {
        this.rating_author = rating_author;
    }

    public String getRating_target() {
        return rating_target;
    }

    public void setRating_target(String rating_target) {
        this.rating_target = rating_target;
    }
}
