package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2020-12-30 21:17
 */
@RestController
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    public String serverURL;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")  // 负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")  // 负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback"
            , blockHandler = "blockHandler"
            , exceptionsToIgnore = {IllegalArgumentException.class}
    )  // 负责sentinel控制台配置违规
    public CommonResult<Payment> getServerPort(@PathVariable("id") Long id) {
        CommonResult forObject = restTemplate.getForObject(serverURL + "/payment/" + id,
                CommonResult.class,
                id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (forObject.getData() == null) {
            throw new NullPointerException("结果为空，空指针异常");
        }
        return forObject;
    }

    // 本利fallback方法
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult(404, "兜底异常handlerFallback， exception异常内容：" + e.getMessage());
    }

    // 本例blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        return new CommonResult(504, "blockHandler-sentinel限流，异常信息：" + e.getMessage());
    }

    ;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> payment(@PathVariable Long id) {
        CommonResult<Payment> result = paymentService.payment(id);
        return result;
    }
}
