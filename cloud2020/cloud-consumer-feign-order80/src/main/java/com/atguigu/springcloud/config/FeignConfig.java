package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 小吴
 * @Date 2023/01/31 16:59
 * @Version 1.0
 */
@Configuration
//Feign日志管理
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;     //代表开启一个详细日志
    }
}