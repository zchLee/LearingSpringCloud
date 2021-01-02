package com.springcloud.dao;

import com.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzc
 * @create 2021-1-1 21:55
 */
@Mapper
public interface OrderDao {

    // 新建订单
    void createOrder(Order order);

    // 修改订单状态
    void updateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}
