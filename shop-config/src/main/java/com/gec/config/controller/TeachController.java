package com.gec.config.controller;


import com.gec.config.config.ConfigConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RefreshScope
public class TeachController {

    @Autowired
    private ConfigConfiguration configConfiguration;

    @Value("${custom.msg}")
    private String msg;

    @GetMapping("/shared")
    public String shared(){
        return msg;
    }


    @GetMapping("/teach")
    public String msg(){
        return configConfiguration.getMsg();
    }

    @Value("${globalConfig}")
    private String globalMsg;

    @GetMapping("/global")
    public String global(){
        return globalMsg;
    }
}
