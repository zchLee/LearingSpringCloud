package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lzc
 * @create 2020-12-26 19:26
 */
@SpringBootApplication
@EnableDiscoveryClient // 作为consul或者zookeeper作为注册中心时 注册服务
public class OrderMain81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class, args);
    }
}
