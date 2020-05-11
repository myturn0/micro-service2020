package com.apollo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.apollo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/8
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private TestService service;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }

    @GetMapping("/testA")
    public String testA() throws Exception {
        //这里如果设置为"线程数"，而不是QPS，
        //那么当前线程正在执行时，如果超过设定的阈值，就会进行流控
        Thread.sleep(1000);
        return "-------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + " testB");
        return "-------------testB";
    }

    @GetMapping("/testD")
    public String testD() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        log.info("testD 测试RT");
        return "-------------testD";
    }

    @GetMapping("/testE")
    public String testE() throws Exception {
        log.info("testE 异常比例");
        int age = 10 / 0;
        return "-------------testE";
    }

    @GetMapping("/testF")
    public String testF() throws Exception {
        log.info("testF 异常数");
        int age = 10 / 0;
        return "-------------testF";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testHotKeyHandler")//其中，value只要是唯一值就可以，例如，abc001
    public String testHotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2) {
        //这种异常，会直接打印到前端（因为这里没有try，catch）
        //这种异常，SentinelResource注解的blockHandler并不会执行
        int age = 10 / 0;
        return "-------------testHotKey";
    }

    public String testHotKeyHandler(String p1, String p2, BlockException block) {
        //用于替换sentinel的默认系统提示：Blocked by Sentinel （flow limiting）
        return "-------------testHotKey+++++++++++++block exception" + block;
    }
}
