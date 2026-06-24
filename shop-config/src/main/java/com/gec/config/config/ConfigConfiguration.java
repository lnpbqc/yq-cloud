package com.gec.config.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "long.prefix") // 使用这个注解无需使用 @RefreshScope 进行注解的刷新
@Data
public class ConfigConfiguration {
    private String test; // 这就是 long.prefix.test
    private String msg; // long.prefix.msg
}
