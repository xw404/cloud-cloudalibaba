package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 小吴
 * @Date 2023/01/28 16:35
 * @Version 1.0
 */
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id")Long id);
}
