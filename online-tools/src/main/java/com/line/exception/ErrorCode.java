package com.line.exception;

public enum  ErrorCode
{
    //1开头程序性错误
    DB_ERR(100001,"数据库操作异常"),

    //2业务错误
    LOGIN_ERR(200001,"请重新登录");


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
