package com.lea.springcloud.dao;

import com.lea.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lzc
 * @create 2020-12-25 15:48
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
