package com.lea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.applet.Main;

/**
 * @author lzc
 * @create 2020-12-25 18:32
 */
@SpringBootApplication
@EnableEurekaServer // 标识此服务是服务注册中心
public class Eureka7001Main {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001Main.class, args);
    }


}
