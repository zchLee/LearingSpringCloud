package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;
import com.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lzc
 * @create 2021-1-1 14:45
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(1L, UUID.randomUUID().toString()));
    }

    public CommonResult  handleException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName());
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流测试OK", new Payment(1L, UUID.randomUUID().toString()));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "自定义限流测试OK", new Payment(1L, UUID.randomUUID().toString()));
    }
}
