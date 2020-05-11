package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/7
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApp83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp83.class, args);
    }
}
