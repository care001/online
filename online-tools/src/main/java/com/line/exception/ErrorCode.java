package com.line.exception;

public enum  ErrorCode
{
    LOGIN_ERRPWD(100001,"登录密码错误");


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
