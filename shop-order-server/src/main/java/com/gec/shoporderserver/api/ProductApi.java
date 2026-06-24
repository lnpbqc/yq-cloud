package com.gec.shoporderserver.api;

import com.gec.shopproductapi.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "shop-product-server")
public interface ProductApi {
    @GetMapping("/products/{pid}")
    Product getProductByPid(@PathVariable("pid") Long pid);

    @RequestMapping("/sell/{pid}/{counts}")
    Product buy(@PathVariable("pid") Long pid, @PathVariable("counts") Integer counts);
}
