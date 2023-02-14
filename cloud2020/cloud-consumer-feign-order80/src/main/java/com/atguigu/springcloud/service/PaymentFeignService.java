package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 小吴
 * @Date 2023/01/31 16:08
 * @Version 1.0
 */
@Component    //能扫描到
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")     //微服务调用接口
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id );

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
