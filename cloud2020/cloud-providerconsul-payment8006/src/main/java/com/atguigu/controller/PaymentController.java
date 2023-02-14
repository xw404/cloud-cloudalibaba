package com.atguigu.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @Author 小吴
 * @Date 2023/01/31 9:36
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private  String serverPort;

    @GetMapping(value = "/payment/consul")
    public String payment(){
        return "SpringCloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
