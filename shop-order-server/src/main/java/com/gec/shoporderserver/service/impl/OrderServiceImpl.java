package com.gec.shoporderserver.service.impl;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.shoporderapi.entity.Order;
import com.gec.shoporderserver.api.ProductApi;
import com.gec.shoporderserver.mapper.OrderMapper;
import com.gec.shoporderserver.service.OrderService;
import com.gec.shopproductapi.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductApi productApi;

    @Override
    public Order createOrder(Long pid, Long uid) {
        Order order = new Order();
//        Product product = restTemplate.getForObject("http://shop-product-server/products/"+pid, Product.class);
        Product product = productApi.getProductByPid(pid);
        order.setPid(pid);
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());

        //用户
        order.setUid(uid);
        order.setUsername("zbc");
        order.setNumber(1);

        log.info("order created:{}", order);
        // 保存订单
        super.save(order);

        return order;
    }
}
