package com.gec.shoporderserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.shoporderapi.entity.Order;

public interface OrderService extends IService<Order> {
    Order createOrder(Long pid, Long uid);

    Order buyProduct(Long pid, Integer counts, Long uid);
}