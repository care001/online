package com.line.utils;

import org.apache.http.client.utils.DateUtils;

import java.util.Date;
import java.util.Random;

public class OrderNoUtil {

    /**
     * 生成订单号
     * @return
     */
    public static String generateNo(String prefix) {
        StringBuffer sb = new StringBuffer(prefix);
        sb.append(DateUtils.formatDate( new Date(),"yyyyMMddHHmmss"));
        Random random = new Random();
        int orderId = random.nextInt(8);
        orderId += 9;
        sb.append(String.valueOf(orderId));
        return sb.toString();
    }

    /*public static void main(String[] args) {
        System.out.println( new Random().nextInt(100));
        System.out.println(generateNo("1"));
    }*/
}
