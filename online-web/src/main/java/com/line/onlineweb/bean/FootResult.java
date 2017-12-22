package com.line.onlineweb.bean;

public enum FootResult {
    WIN("主胜"),
    LOSS("客胜"),
    SAME("平"),
    GIVE_LOSS("让球客胜"),
    GIVE_WIN("让球主胜"),
    GIVE_SAME("让球平"),;

    private String value;

    FootResult(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
