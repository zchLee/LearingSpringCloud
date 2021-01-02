package com.springcloud.service.impl;

import com.springcloud.dao.OrderDao;
import com.springcloud.domain.Order;
import com.springcloud.service.AccountService;
import com.springcloud.service.OrderService;
import com.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2021-1-1 22:13
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;
    // 开启全局事务
    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("------》新建订单");
        orderDao.createOrder(order);

        log.info("------》订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("------》调用账户服务，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------》调用账户服务，扣减完成");

        log.info("------》修改订单状态");
        orderDao.updateOrder(order.getUserId(), 0);

        log.info("----->订单完成<-----");
    }


}
