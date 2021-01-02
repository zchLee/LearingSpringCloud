package com.springcloud.service.impl;

import com.springcloud.dao.AccountDao;
import com.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author lzc
 * @create 2021-1-1 23:04
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("开始减少账户金额");
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {e.printStackTrace(); }
        accountDao.decrease(userId, money);
        log.info("减少账户金额完成");
    }
}
