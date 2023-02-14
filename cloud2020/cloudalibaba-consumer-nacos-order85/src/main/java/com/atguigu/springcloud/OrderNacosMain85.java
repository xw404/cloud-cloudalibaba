package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 小吴
 * @Date 2023/02/06 13:24
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderNacosMain85
{
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain85.class, args);
    }
}
