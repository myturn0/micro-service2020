package com.apollo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/8
 */
@Service
public class TestService {

    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
