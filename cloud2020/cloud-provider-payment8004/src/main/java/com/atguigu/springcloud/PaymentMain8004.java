package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 小吴
 * @Date 2023/01/30 15:16
 * @Version 1.0
 */
//SpringBoot整合zookeeper客户端
    @SpringBootApplication

    //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
    @EnableDiscoveryClient      //服务器打交道都用这个
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
