package com.lea.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzc
 * @create 2020-12-27 20:35
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/ok/{id}")
    String payment(@PathVariable("id") Integer id);
}
