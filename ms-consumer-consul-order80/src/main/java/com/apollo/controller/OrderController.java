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
    private static final String BASE_ADDRESS = "http://ms-provider-consul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        String result = restTemplate
                .getForObject(BASE_ADDRESS + "/payment/consul", String.class);
        return result;
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate
                .getForObject(BASE_ADDRESS + "/payment/zipkin", String.class);
        return result;
    }
}
