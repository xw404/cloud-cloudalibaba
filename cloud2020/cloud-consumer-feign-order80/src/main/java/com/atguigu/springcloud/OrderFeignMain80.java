package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 小吴
 * @Date 2023/01/31 16:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients      //和eureka结合支持负载均衡
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
