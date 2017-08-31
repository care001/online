package com.line.onlineweb.bean;


import java.io.Serializable;


public class JsonResult implements Serializable {
    public Boolean success;
    public String  errcode;
    public String  errmsg;
    public Object  result;

    private JsonResult() {}

    public static JsonResult wrapper(Boolean success)
    {
        JsonResult json = new JsonResult();
        json.success = true;
        json.result = success;
        return json;
    }

    public static JsonResult wrapper(Object o)
    {
        JsonResult json = new JsonResult();
        json.success = true;
        json.result = o;
        return json;
    }

}
