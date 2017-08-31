package com.line.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    static String  regEx = "[\u4e00-\u9fa5]";
    static Pattern pat   = Pattern.compile(regEx);
    /**
     * 判断是否为中文
     * */
    public static boolean isContainsChinese(String str)
    {
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find())    {
            flg = true;
        }
        return flg;
    }

    public static boolean isEmpty(String strMsg){

        if(strMsg==null||strMsg.trim().equals("")){
            return true;
        }
        return false;
    }
}
