package com.springcloud.controller;

import com.lea.springcloud.entities.CommonResult;
import com.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author lzc
 * @create 2021-1-1 22:25
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult create(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
        return CommonResult.ok();
    }
}
