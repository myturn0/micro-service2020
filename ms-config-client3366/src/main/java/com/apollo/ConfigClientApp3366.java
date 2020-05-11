package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/6
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApp3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp3366.class, args);
    }
}
