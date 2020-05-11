package com.apollo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.apollo.CustomBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/9
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/testResource")
    @SentinelResource(value = "testResource", blockHandler = "resourceHandler")//其中，value只要是唯一值就可以，例如，abc001
    public String testResource() {
        return "200 ------------- testResource";
    }

    public String resourceHandler(BlockException block) {
        return "------------- testResource 不可用" + block;
    }

    @GetMapping("/rate/testUrl")
    @SentinelResource("testUrl")//其中，value只要是唯一值就可以，例如，abc001
    public String testUrl() {
        return "200 ------------- testUrl，在配置时，写上资源名：/rate/testUrl，则是限制url，如果写上testUrl，则是按照资源进行限制";
    }

    @GetMapping("/rate/customHandler")//注意，当直接限制url时，SentinelResource中的blockHandler并不生效
    @SentinelResource(
            value = "testCustomHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "exceptionHandler")//其中，value只要是唯一值就可以，例如，abc001
    public String testCustomHandler() {
        return "200 ------------- testCustomHandler";
    }
}
