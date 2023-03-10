package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 小吴
 * @Date 2023/02/08 14:41
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)    //排除这个，使用我们自己的数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageMainApp2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }

}

