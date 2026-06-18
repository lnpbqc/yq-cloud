package com.gec.shoporderserver.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FallbackController {
    @RequestMapping("/fallBack1")
    public String fallBack1(){
        try {
            log.info("fallBack1执行业务逻辑");
            //模拟业务耗时
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fallBack1";
    }
    int i=0;
    @RequestMapping("/fallback2") // 异常比例
    public String fallBack2(){
        log.info("fallback2执行业务逻辑");
        //模拟出现异常，异常比例为33%
        if(++i%3==0){
            throw new RuntimeException();
        }
        return "fallback2";
    }

    @RequestMapping("/fallback3") // 异常数
    public String fallback3(String name){
        if(name.equals("sentinel"))throw new RuntimeException();
        return "fallback3";
    }

    @RequestMapping("/fallback4") // 查询商品的一个接口
    @SentinelResource("/fallback4")
    public String fallback4(int pid){
        return "fallback4:"+pid;
    }
}
