package com.gec.shopproductapi.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_product")
public class Product {
    @TableId(type= IdType.AUTO)
    private Long id;//主键
    private String name;//商品名称
    private Double price;//商品价格
    private Integer stock;//库存
}