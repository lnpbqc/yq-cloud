package com.gec.shoporderserver.api;

import com.gec.shopproductapi.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shop-product-server")
public interface ProductApi {
    @GetMapping("/products/{pid}")
    Product getProductByPid(@PathVariable("pid") Long pid);
}
