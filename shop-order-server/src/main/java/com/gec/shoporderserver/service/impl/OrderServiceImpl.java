package com.gec.shoporderserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.shoporderapi.entity.Order;
import com.gec.shoporderserver.api.ProductApi;
import com.gec.shoporderserver.mapper.OrderMapper;
import com.gec.shoporderserver.service.OrderService;
import com.gec.shopproductapi.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    @Transactional
//    @GlobalTransactional
    @Override
    public Order buyProduct(Long pid, Integer counts, Long uid) {
        Product buy = productApi.buy(pid, counts);
        Order order = new Order();
        order.setPid(pid);
        order.setProductName(buy.getName());
        order.setProductPrice(buy.getPrice()*counts); // 假如这里还有去给用户余额进行扣减的api
        order.setUid(uid);
        order.setNumber(counts);
        order.setUsername("zbc");
        save(order);
        if(uid==123)throw new RuntimeException();
        return order;
    }
}
