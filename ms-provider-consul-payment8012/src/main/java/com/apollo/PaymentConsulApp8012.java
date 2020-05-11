package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@SpringBootApplication
//该注解用于向consul或者zookeeper作为注册中心时，注册服务
@EnableDiscoveryClient
public class PaymentConsulApp8012 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApp8012.class, args);
    }
}
