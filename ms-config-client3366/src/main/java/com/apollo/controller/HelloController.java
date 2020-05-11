package com.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/4
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String serverPort;

    @Value("${test.name}")
    private String testName;

    @GetMapping("/test")
    public String testName() {
        return testName;
    }

    @RequestMapping("/config")
    public String config() {
        return "获取成功：" + name + serverPort;
    }
}
