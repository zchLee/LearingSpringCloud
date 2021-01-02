package com.springcloud.service;

import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lzc
 * @create 2021-1-1 17:00
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(500, "服务降级返回");
    }
}
