package com.gec.shoporderserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.gec.shoporderserver.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ShopOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopOrderServerApplication.class, args);
    }

}
