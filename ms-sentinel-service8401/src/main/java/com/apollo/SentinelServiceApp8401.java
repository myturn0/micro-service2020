package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApp8401.class, args);
    }
}
