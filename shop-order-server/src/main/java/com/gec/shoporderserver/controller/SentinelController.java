package com.gec.shoporderserver.controller;

import com.gec.shoporderserver.api.ProductApi;
import com.gec.shoporderserver.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SentinelController {
    private final ProductService productService;

    public SentinelController( ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/sentinel1")
    public String sentinel1(){
        //模拟一次网络延时
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel1";
    }
    @RequestMapping("/sentinel2")
    public String sentinel2(){
        return "测试高并发下的问题";
    }

    @RequestMapping("/sentinel-read")
    public String readReq(){
        return "读请求";
    }
    @RequestMapping("/sentinel-write")
    public String writeReq(){
        return "写请求";
    }

    @RequestMapping("/sentinel/queryOrder")
    public String queryOrder(){
        productService.queryProduct();
        return "查询订单";
    }
    @RequestMapping("/sentinel/createOrder")
    public String createOrder(){
        productService.queryProduct();
        return "创建订单";
    }
}