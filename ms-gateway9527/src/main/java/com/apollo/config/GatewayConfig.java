package com.apollo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@Configuration
public class GatewayConfig {

    /*
    两种配置路由的方式：1）Bean；2）application.yml方式
    此为方法1

    配置了一个id为route_name的路由规则，
    当访问：http://localhost:9527/guonei时，
    自动转发到地址：http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_payment",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
