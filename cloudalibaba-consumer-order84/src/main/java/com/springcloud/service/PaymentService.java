package com.springcloud.service;

import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzc
 * @create 2021-1-1 16:58
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("payment/{id}")
    CommonResult<Payment> payment(@PathVariable("id") Long id);
}
