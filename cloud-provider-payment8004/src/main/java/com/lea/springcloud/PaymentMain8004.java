package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lzc
 * @create 2020-12-26 14:18
 */
@SpringBootApplication
@EnableDiscoveryClient  // 该注解用于向使用consul或者zookeeper作为注册中心时 注册服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
