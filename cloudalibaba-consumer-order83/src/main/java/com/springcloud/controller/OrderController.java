package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-30 21:17
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL+"/payment/nacos/" + id, String.class);
    }
}
