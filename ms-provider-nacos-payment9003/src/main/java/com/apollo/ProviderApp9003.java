package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApp9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp9003.class, args);
    }
}
