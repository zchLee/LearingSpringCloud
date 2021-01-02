package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lzc
 * @create 2021-1-1 22:12
 */
@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
