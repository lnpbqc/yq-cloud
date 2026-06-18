package com.gec.shoporderserver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.gec.shoporderapi.entity.Order;
import com.gec.shoporderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/save")  //测试方便使用Get方式
    public Order order(Long pid, Long uid){
        return orderService.createOrder(pid, uid);
    }
}