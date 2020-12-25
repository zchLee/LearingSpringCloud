package com.lea.springcloud.service;

import com.lea.springcloud.entities.Payment;

/**
 * @author lzc
 * @create 2020-12-25 15:59
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPayment(Long id);}
