package com.apollo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.apollo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/7
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/consumer/{id}")
//    @SentinelResource(value = "consumerFallback", fallback = "handleFallback")
//    @SentinelResource(value = "consumerBlockHandler", blockHandler = "handleBlock")
    @SentinelResource(value = "consumerFallbackBlock",
            fallback = "handleFallback",
            blockHandler = "handleBlock",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate
                .getForObject(serviceUrl + "/payment/" + id, String.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        } else if (result == null) {
            throw new NullPointerException("NullPointerException，该Id没有对应的记录");
        }
        return result;
    }

    public String handleFallback(@PathVariable("id") Integer id, Throwable throwable) {
        return "兜底异常fallback，异常信息："  + id + throwable;
    }

    public String handleBlock(@PathVariable("id") Integer id, BlockException be) {
        return "限流异常 " + be;
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer2/{id}")
    public String count2(@PathVariable("id") Integer id) {
        return paymentService.payment(id);
    }
}
