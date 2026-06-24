package com.gec.shopproductserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.shopproductapi.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}