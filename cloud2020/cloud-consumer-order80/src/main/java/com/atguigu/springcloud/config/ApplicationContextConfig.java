package com.atguigu.springcloud.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 小吴
 * @Date 2023/01/29 13:21
 * @Version 1.0
 */
//配置类
@Configuration
public class ApplicationContextConfig {

    @LoadBalanced   //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力（必要条件。不然报错）
    //（默认轮询）
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
