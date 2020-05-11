package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/7
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApp84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp84.class, args);
    }
}
