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
public class ConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3377.class, args);
    }
}
