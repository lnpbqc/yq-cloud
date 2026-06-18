package com.gec.shopproductserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.gec.shopproductserver.mapper")
@EnableDiscoveryClient
public class ShopProductServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopProductServerApplication.class, args);
    }

}
