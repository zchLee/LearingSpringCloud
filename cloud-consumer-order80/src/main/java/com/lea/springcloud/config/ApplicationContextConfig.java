package com.lea.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzc
 * @create 2020-12-25 16:40
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // 赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
