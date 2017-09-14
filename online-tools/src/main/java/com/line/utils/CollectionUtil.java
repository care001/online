package com.line.utils;

import java.util.List;

public class CollectionUtil {

    public static boolean listIsEmpty(List list){
        if(list == null || list.size()<1 ){
            return true;
        }
        return false;
    }
}
