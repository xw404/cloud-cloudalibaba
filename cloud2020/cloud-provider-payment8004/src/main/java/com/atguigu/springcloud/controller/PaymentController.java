package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author 小吴
 * @Date 2023/01/30 15:19
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "SpringCloud with zookeeper:"+serverPort+ UUID.randomUUID().toString();
    }
}
