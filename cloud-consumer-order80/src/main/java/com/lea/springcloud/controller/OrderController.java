package com.lea.springcloud.controller;

import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;
import com.lea.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

/**
 * @author lzc
 * @create 2020-12-25 16:37
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",
               payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,
                CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String lb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0) {
            return "没有服务";
        }
        ServiceInstance instance = loadBalance.instances(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/get/1", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",
                String.class);
    }
}
