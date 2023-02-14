package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 小吴
 * @Date 2023/01/30 19:14
 * @Version 1.0
 */
@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class OrderZKMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderZKMain80.class,args);
    }
}
