package com.lea.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lzc
 * @create 2020-12-28 13:29
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentTimeOut(Integer id) {
        return "------ PaymentFallBackService ---- fallback paymentTimeOut ,兜底方法 ";
    }

    @Override
    public String payment(Integer id) {
        return "------ PaymentFallBackService ---- fallback payment ,兜底方法 ";
    }
}
