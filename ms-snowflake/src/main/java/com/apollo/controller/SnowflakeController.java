package com.apollo.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/11
 */
@RestController
public class SnowflakeController {

    private static long beginTime = 1288834974657L;

    //1号机房，0号机器
    private static Snowflake snowflake =
            new Snowflake(new Date(beginTime), 0, 1, true);
    //workerId可以使用
//    long workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
//    出错时：
//    long workerId = NetUtil.getLocalhostStr().hashCode();

    @GetMapping("/snowflake")
    public String index() {
        return snowflake.nextIdStr();
    }
}
