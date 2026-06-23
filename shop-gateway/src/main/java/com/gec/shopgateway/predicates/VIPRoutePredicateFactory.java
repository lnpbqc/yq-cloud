package com.gec.shopgateway.predicates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
@Slf4j
public class VIPRoutePredicateFactory  extends AbstractRoutePredicateFactory<VIPRoutePredicateFactory.Config> {
    public VIPRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String uri = serverWebExchange.getRequest().getURI().toString();
                log.info("uri: {}", uri);
                // http://localhost/s?wd=haha&user=gec&user=123
                // getFirst(config.param); 就是拿它当hashmap 传入k可以拿到v
                String param = serverWebExchange.getRequest().getQueryParams().getFirst(config.param); // k-v 最后是拿到 user=gec
                log.info("param: {}", param);
                // StringUtils.hasText(param) 有没有一个是user的查询参数
                // param.equals(config.value) 它这个查询的值是不是我所配置的那个字符串
                return StringUtils.hasText(param) && param.equals(config.value);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param","value");
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Config{
        private String param;
        private String value;
    }
}
