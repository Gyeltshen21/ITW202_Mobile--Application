package com.example.todo_18;

public class Sports {
    private String title, info;
    public Sports(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Sports(String title, String info){
        this.title = title;
        this.info = info;
    }
}
