package com.lea.springcloud.service.impl;

import com.lea.springcloud.dao.PaymentDao;
import com.lea.springcloud.entities.Payment;
import com.lea.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-25 16:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
