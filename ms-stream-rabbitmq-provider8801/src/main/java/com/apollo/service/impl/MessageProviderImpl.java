package com.apollo.service.impl;

import com.apollo.service.IMessageProvider;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/6
 */
@EnableBinding(Source.class) //定义消息的推送管道，outputs
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> msg = MessageBuilder.withPayload(serial).build();
        output.send(msg);
        System.out.println("*******serial:" + serial);
        return null;
    }
}
