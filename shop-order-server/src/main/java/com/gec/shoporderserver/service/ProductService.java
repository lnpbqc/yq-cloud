package com.gec.shoporderserver.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @SentinelResource("queryProduct")
    public void queryProduct() {

    }
}
