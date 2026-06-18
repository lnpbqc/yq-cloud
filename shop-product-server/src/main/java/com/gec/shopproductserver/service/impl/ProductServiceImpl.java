package com.gec.shopproductserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.shopproductserver.mapper.ProductMapper;
import com.gec.shopproductserver.service.ProductService;
import org.springframework.stereotype.Service;
import com.gec.shopproductapi.entity.Product;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}