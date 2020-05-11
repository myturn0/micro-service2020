package com.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/9
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "第一个");
        map.put(2, "第二个");
        map.put(3, "第三个");
    }

    @GetMapping("/payment/{id}")
    public String payment(@PathVariable("id") Integer id) {
        return "获取到的数据是：" + map.get(id) + " 端口号：" + serverPort;
    }
}
