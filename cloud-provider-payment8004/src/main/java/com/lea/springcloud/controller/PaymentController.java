package com.lea.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lzc
 * @create 2020-12-26 14:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("payment/zk")
    public String paymentzk() {
        return "spring cloud with zookeeper :" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
