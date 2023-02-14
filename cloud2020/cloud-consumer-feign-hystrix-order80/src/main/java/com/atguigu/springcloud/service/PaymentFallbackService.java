package com.atguigu.springcloud.service;

import org.springframework.context.annotation.Configuration;

/**
 * @Author 小吴
 * @Date 2023/02/01 16:44
 * @Version 1.0
 */
@Configuration
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back +paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back + paymentInfo_TimeOut";
    }
}
