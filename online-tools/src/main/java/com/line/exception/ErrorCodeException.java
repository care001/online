package com.line.exception;

public class ErrorCodeException extends RuntimeException {

    private String errcode;

    public ErrorCodeException(ErrorCode errcode) {
        super(errcode.getErrorMsg());
        this.errcode = errcode.getErrorCode()+"";
    }

    public ErrorCodeException(ErrorCode errcode, String errMessage) {
        super(errMessage);
        this.errcode = errcode.getErrorCode()+"";
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
}
