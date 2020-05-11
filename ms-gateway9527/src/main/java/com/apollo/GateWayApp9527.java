package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApp9527 {

    /*

    注意，url中必须加上?uname=123才行，就是filter中自定义的过滤器实现的功能

     */
    public static void main(String[] args) {
        SpringApplication.run(GateWayApp9527.class, args);
    }
}
