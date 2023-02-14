package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 小吴
 * @Date 2023/01/31 14:15
 * @Version 1.0
 */

//自定义负载均衡规则，查资料决定使用的方法。默认为轮询
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return  new RandomRule();   //定义为随机
    }
}
