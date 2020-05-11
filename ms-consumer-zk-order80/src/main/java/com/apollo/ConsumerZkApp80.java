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
public class ConsumerZkApp80 {
    /*
    最后调用：http://localhost/consumer/payment/zk
    测试成功，提供者和消费者都注册进了zookeeper，并且可以正常调用
     */
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkApp80.class, args);
    }
}
