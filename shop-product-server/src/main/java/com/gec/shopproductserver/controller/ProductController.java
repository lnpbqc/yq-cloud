package com.gec.shopproductserver.controller;

import com.alibaba.fastjson.JSON;
import com.gec.shopproductapi.entity.Product;
import com.gec.shopproductserver.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    //商品信息查询 v1/  v2
    @RequestMapping("products/{pid}")
    public Product findByPid(@PathVariable("pid") Long pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.getById(pid);
        product.setName(product.getName()+"from port:"+port);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }

    // 卖出商品进行扣减库存
    @Transactional
    @RequestMapping("/sell/{pid}/{counts}")
    public Product sell(@PathVariable("pid") Long pid,@PathVariable("counts") Long counts) {
        Product product = productService.getById(pid);
        if(counts<=0) {
            throw new IllegalArgumentException("counts should be greater than 0");
        }
        if(counts>product.getStock()){
            throw new IllegalArgumentException("counts should be smaller than product.getStock");
        }
        product.setStock(product.getStock()-counts.intValue());
        productService.updateById(product);
        if(counts>=5)throw new RuntimeException();
        return product;
    }
}