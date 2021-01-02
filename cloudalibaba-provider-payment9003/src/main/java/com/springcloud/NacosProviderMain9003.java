package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lzc
 * @create 2020-12-30 20:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9003.class, args);
    }
}
