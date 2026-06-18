package com.gec.shoporderserver.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @SentinelResource("queryProduct")
    public void queryProduct() {
        // 比如进行一些MYSQL数据库操作等耗时操作
    }
}
