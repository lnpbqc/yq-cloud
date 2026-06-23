package com.gec.shopgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalTokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 前置操作 PRE
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        log.info("token: {}", token);
        log.info("pre weather: {}", exchange.getResponse().getHeaders().getFirst("weather"));
        if(StringUtils.hasText(token)){
            // todo: 鉴权操作
            return chain.filter(exchange).doFinally((result)->{
                // 这里的逻辑操作就是后置操作 POST
                String weather = exchange.getResponse().getHeaders().getFirst("weather");
                log.info("post weather: {}", weather);
            });
        }
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
