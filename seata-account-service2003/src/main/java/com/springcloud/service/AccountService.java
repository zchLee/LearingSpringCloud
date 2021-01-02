package com.springcloud.service;

import java.math.BigDecimal;

/**
 * @author lzc
 * @create 2021-1-1 22:12
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
