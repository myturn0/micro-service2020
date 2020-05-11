package com.apollo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@RestController
@Slf4j
public class OrderController {
    private static final String BASE_ADDRESS = "http://ms-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate
                .getForObject(BASE_ADDRESS + "/payment/zk", String.class);
        return result;
    }
}
