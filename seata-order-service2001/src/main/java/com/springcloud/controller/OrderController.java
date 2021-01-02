package com.springcloud.controller;

import com.lea.springcloud.entities.CommonResult;
import com.springcloud.domain.Order;
import com.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2021-1-1 22:25
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("create/order")
    public CommonResult create(Order order) {
        orderService.create(order);
        return CommonResult.ok();
    }
}
