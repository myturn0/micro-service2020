package com.apollo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@RestController
@Slf4j
public class PaymentController {
    private static AtomicInteger counter = new AtomicInteger(0);

    @Value("${server.port}")
    private String serverPort;

    //如果大量线程访问/payment/consul，那么/payment/consul/simple也会变慢
    //可以使用jmeter进行压力测试
    @GetMapping(value = "/payment/consul/simple")
    public String paymentConsulSimple() {
        return "spring cloud with consul: "
                + serverPort + "\t" + UUID.randomUUID().toString() + " === simple";
    }

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() throws Exception {
        Thread.sleep(2000);
        System.out.println(counter.get());
        return "spring cloud with consul: "
                + serverPort + "\t" + UUID.randomUUID().toString() + "=====" + counter.getAndIncrement();
    }

    @GetMapping(value = "/payment/get")
    public String getOnt() {
        return "get" + serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String getLb() {
        return "loadbalance" + serverPort;
    }
}
