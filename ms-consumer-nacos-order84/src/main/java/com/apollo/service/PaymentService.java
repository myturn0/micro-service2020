package com.apollo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/10
 */
@FeignClient(
        value = "ms-provider-nacos",
        fallback = PaymentFallback.class)
//注意，fallback只有在配置了sentinel才会执行，不配置，那么消费者一直等待提供者，
//可能导致消费者被拖垮的情况
public interface PaymentService {

    @GetMapping("/payment/{id}")
    String payment(@PathVariable("id") Integer id);
}
