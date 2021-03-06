package com.apollo.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ：liuyunyang
 * @since ：Created in 2020/5/5
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************come in MyLogGatewayFilter" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("uname");
        if (username == null) {
            log.info("********用户名是非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //如果是合法的，就放行，让下一个过滤器进行处理
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
