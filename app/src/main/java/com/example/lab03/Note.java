package com.example.lab03;

public abstract class Note {
    public String title;
    public String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //Method
    public String getTitle() {
        return title;
    }

    public abstract String display();


}