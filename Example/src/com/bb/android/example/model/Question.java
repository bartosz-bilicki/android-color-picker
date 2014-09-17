package com.bb.android.example.model;

public class Question {
    private final String text;
    private final boolean isTrue;


    public Question(String text, boolean isTrue) {
        this.text = text;
        this.isTrue = isTrue;
    }

    public String getText() {
        return text;
    }

    public boolean isTrue() {
        return isTrue;
    }
}
