package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

/**
 * @author lzc
 * @create 2021-1-1 21:52
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动配置
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderService2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService2001.class, args);
    }
}
