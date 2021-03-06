package com.line.exception;

public enum  ErrorCode
{
    //1开头程序性错误
    DB_ERR(100001,"数据库操作异常"),
    REFLEX_ERR(100001,"反射处理异常"),

    //2业务错误
    LOGIN_ERR(200001,"您还没有登录");


    private int    errorCode;
    private String errorMsg;

    ErrorCode(int errorCode, String errorMsg)
    {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }
}
