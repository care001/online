package com.line.utils;

import com.line.exception.ErrorCode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
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


    public static String capitalize(String name){
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static String toMapKey(String name){
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(name);
        while (m.find())
        {
            m.appendReplacement(sb, "_\\" + m.group().toLowerCase());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Field fields[] = ErrorCode.class.getDeclaredFields();
        // 遍历数据

            for (Field field : fields) {
                if (null != field) {
                    // 全部转化为大写
                    String dbfieldname = StringUtils.toMapKey(field.getName());
                    System.out.println("------>"+field.getGenericType().toString());
                    System.out.println(field.getType().toString());


                }
            }}

}
