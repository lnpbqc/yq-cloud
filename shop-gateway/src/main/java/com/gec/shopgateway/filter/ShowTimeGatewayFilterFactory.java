package com.gec.shopgateway.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ShowTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<ShowTimeGatewayFilterFactory.Config> {

    public ShowTimeGatewayFilterFactory() {
        super(Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("show");
    }


    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if(!config.show){
                    return chain.filter(exchange);
                }
                long startTime = System.currentTimeMillis();

                return chain.filter(exchange).doFinally((result)->{
                    long endTime = System.currentTimeMillis();
                    log.info("{} costs {}ms", exchange.getRequest().getURI(), endTime - startTime);
                });
            }
        };
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Config {
        private Boolean show;
    }
}
