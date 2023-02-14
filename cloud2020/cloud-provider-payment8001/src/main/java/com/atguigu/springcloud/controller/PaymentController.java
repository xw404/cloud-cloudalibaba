package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author 小吴
 * @Date 2023/01/28 16:45
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String ServerPort;     //代表集群之后是那台机器提供的服务

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("*******插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功，ServerPort ："+ServerPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id ){

        Payment payment= paymentService.getPaymentById(id);
        log.info("*******查询结果:"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功，ServerPort :"+ServerPort,payment);
        }else{
            return new CommonResult(444,"查询失败,查询ID："+id,null);
        }
    }

    //服务发现Discovery
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取所有被注册的微服务(eureka下的所有微服务)
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element:"+element);
        }
        //获取主机列表（一个名称下的所有实例）
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());

        }
        return this.discoveryClient;
    }

    //测试网关Geteway
    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return ServerPort;
    }

    //暂停程序
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        System.out.println("*****paymentFeignTimeOut from port: "+ServerPort);
        //暂停三秒钟
        TimeUnit.SECONDS.sleep(3);
        return ServerPort;
    }
    //Sleuth链路监控展现
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to 云南，O(∩_∩)O哈哈~";
    }

}
