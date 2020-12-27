package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzc
 * @create 2020-12-27 15:28
 */
@SpringBootApplication
@EnableFeignClients   // 开启Feign 服务调用
public class OrderFeignMain81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain81.class, args);
    }
}
