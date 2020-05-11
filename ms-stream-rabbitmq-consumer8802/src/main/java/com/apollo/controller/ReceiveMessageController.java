package com.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/6
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg) {
        System.out.println("我是消费者1号，========>" + msg.getPayload() + "\t port: " + serverPort);
    }
}
