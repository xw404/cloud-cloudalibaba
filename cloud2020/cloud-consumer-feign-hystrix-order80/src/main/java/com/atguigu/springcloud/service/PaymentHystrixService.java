package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 小吴
 * @Date 2023/02/01 15:04
 * @Version 1.0
 */
@Component
//80调用8001
//fallback   把类配进接口
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback =PaymentFallbackService.class )        //@Feign+面向接口编程
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
