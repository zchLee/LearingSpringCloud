package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzc
 * @create 2020-12-27 19:42
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class SpringHystrixBoot {

    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixBoot.class, args);
    }
}
