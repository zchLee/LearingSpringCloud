package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lzc
 * @create 2020-12-26 14:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain81 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain81.class, args);
    }
}
