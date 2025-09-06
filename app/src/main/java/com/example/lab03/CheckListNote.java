package com.example.lab03;

import java.util.List;

public class CheckListNote extends Note{

    private final List<String> items;

    public CheckListNote(String title, String content,List<String> items) {
        super(title, content);
        this.items = items;
    }

    public String display() {
        return title+":("+content+")"+items;
        /*System.out.println(title+":("+content+")");
        System.out.println(items);*/
    }
}