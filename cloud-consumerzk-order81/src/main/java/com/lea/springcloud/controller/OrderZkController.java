package com.lea.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-26 14:57
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String payment() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
