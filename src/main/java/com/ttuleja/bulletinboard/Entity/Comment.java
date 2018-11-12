package com.ttuleja.bulletinboard.Entity;

public class Comment {
    String comment_author;
    String comment_content;
    String comment_date;
    int comment_id;
    String comment_target;

    public Comment(String comment_author, String comment_content, String comment_date, int comment_id, String comment_target) {
        this.comment_author = comment_author;
        this.comment_content = comment_content;
        this.comment_date = comment_date;
        this.comment_id = comment_id;
        this.comment_target = comment_target;
    }

    public Comment(){

    }

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_target() {
        return comment_target;
    }

    public void setComment_target(String comment_target) {
        this.comment_target = comment_target;
    }
}
