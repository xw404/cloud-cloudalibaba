package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author 小吴
 * @Date 2023/02/01 8:35
 * @Version 1.0
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Long id){
        return "线程池:"+Thread.currentThread().getName()+
                "paymentInfo_OK, id: "+id+"\t"+"O(∩_∩)O";
    }
    //========服务降级
    /**
     * 超时访问
     * @param id
     * @return
     * @throws InterruptedException
     */
    /*   下面注解说明：在3秒以内走下面正常的业务逻辑，超过三秒走兜底方案fallbackMethod*/
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })     //服务降级
    public String paymentInfo_Timeout(Long id) throws InterruptedException {
        //睡眠几秒
        int TimeNum=5;
        //int age=10/0;
        TimeUnit.SECONDS.sleep(TimeNum);
        return "线程池:"+Thread.currentThread().getName()+
                "paymentInfo_Timeout, id: "+id+"\t"+"O(∩_∩)O,超时"+TimeNum+"秒";
    }
    public String paymentInfo_TimeoutHandler(Long id){
        return "线程池:"+Thread.currentThread().getName()+
                "paymentInfo_TimeoutHandler, id: "+id+"\t"+"8001系统繁忙或运行错误，请稍后再试O(*_*)O";
    }

    //========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    //兜底方案
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
