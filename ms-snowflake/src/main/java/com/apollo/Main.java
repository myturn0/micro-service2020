package com.apollo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("11111111111111111111111111111111111111111".length());
        long time = 2199023255551L;
        long time1 = 1480166465631L;

        Date date = new Date(time1);
        //这里可以用到2039-09-07
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        //大概能用69年
        System.out.println(2039 - 1970);
    }
}
