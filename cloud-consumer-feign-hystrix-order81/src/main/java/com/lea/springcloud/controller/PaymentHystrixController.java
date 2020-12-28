package com.lea.springcloud.controller;

import com.lea.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-27 20:39
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
//    })
    @HystrixCommand
    String paymentTimeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        return paymentHystrixService.paymentTimeOut(id);
    };

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String payment(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment(id);
    };

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "消费端，调用支付系统，对方不符合消费端熔断要求 请求失败。。";
    }

    public String paymentGlobalFallBackMethod() {
        return "Global全局消息，系统异常，请稍后再试";
    }
}
