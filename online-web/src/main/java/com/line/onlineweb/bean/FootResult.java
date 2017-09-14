package com.line.onlineweb.bean;

public enum FootResult {
    WIN(""),
    LOSS(""),
    GIVE_LOSS(""),
    GIVE_WIN("");

    private String value;

    FootResult(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
