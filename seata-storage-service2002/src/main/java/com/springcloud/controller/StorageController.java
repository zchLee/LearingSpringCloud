package com.springcloud.controller;

import com.lea.springcloud.entities.CommonResult;
import com.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2021-1-1 22:52
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return CommonResult.ok();
    }
}
