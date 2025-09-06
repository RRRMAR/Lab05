package com.example.lab03;

import java.util.Date;

public class TextNote extends com.example.lab03.Note {
    private String textContent;

    public TextNote(String title, String content) {
        super(title, content);
    }

    public String getTextContent(){
        return textContent;
    }

    public void setTextContent(String content){
        if (!content.isEmpty()){
            this.textContent = content;
        }
    }
    public String display() {
        return title+"("+content+")";
    }


}

