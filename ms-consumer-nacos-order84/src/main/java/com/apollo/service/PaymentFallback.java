package com.apollo.service;

import org.springframework.stereotype.Component;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/10
 */
@Component
public class PaymentFallback implements PaymentService {
    @Override
    public String payment(Integer id) {
        return "服务提供者有问题，自动进行服务降级";
    }
}
