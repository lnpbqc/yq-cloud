package com.gec.shoporderapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//订单
@Data
@TableName("t_order")
public class Order implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;//订单id
    //用户
    private Long uid;//用户id
    private String username;//用户名
    //商品
    private Long pid;//商品id
    private String productName;//商品名称
    private Double productPrice;//商品单价
    //数量
    private Integer number;//购买数量
}