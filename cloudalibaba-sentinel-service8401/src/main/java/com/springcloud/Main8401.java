package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import sun.applet.Main;

/**
 * @author lzc
 * @create 2020-12-31 18:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main8401 {

    public static void main(String[] args) {
        SpringApplication.run(Main8401.class, args);
    }
}
