package com.apollo.controller;

import com.apollo.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/6
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return provider.send();
    }

}
