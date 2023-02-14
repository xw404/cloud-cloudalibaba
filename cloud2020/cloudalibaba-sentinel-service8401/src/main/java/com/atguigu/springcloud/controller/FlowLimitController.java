package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author 小吴
 * @Date 2023/02/05 15:17
 * @Version 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        log.info(Thread.currentThread().getName()+"\t"+"****testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"****testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
//        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");
        //异常比例
        log.info("testD 测试异常比例");
        int age =10/0;
        return "------testD";
    }
    //测试异常数
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常比例");
        int age = 10/0;
        return "------testE 测试异常比例";
    }

    //测试热点KEY限流
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey123",blockHandler = "deal_testHotKey")
    //注意：没有配置兜底方法，返回错误页面（不友好界面）
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----------------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException b1){
        return "----------------deal_testHotKey";
    }





}
