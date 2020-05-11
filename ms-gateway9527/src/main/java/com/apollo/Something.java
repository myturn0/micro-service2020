package com.apollo;

import java.time.ZonedDateTime;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
public class Something {
    public static void main(String[] args) {
        //这个可以用于设置geteway路由中的时间
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
