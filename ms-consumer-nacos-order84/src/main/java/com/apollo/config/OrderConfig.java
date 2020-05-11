package com.apollo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/7
 */
@Configuration
public class OrderConfig {

    @Bean
    @LoadBalanced //这里必须加上，否则当nacos找到多个同名的微服务实例时，无法确定使用哪个
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
