package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzc
 * @create 2021-1-1 21:52
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动配置
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageService2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002.class, args);
    }
}
