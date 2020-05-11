package com.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/4
 *
 *
 * 这里是spring-cloud-config的服务器
 *
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApp3344 {

    /*
    git仓库的内容：
    spring:
      profiles:
        active:
          - dev
    ---
    spring: #开发环境
      profiles: dev
      application:
        name: ms-config-dev
    ---
    spring: #测试环境
      profiles: test
      application:
        name: ms-config-test
    # 必须保存为UTF-8格式

    调用方式：
    开发：http://localhost:3344/application-dev.yml
    测试：http://localhost:3344/application-test.yml

     */


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp3344.class, args);
    }
}