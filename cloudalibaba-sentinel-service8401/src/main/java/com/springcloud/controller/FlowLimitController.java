package com.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzc
 * @create 2020-12-31 18:38
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName() + "\t :----testA");
        return "------teseA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        log.info(" :----异常比例");
        int a = 10 /0;
        return "------testD";
    }

    @GetMapping("/testhostKey")
    @SentinelResource(value = "testHostKey", blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2
                              ) {
//        int a = 10 / 0;
        return "------testHostKey";
    }

    public String deal_testHostKey(String p1, String p2, BlockException e) {
        System.out.println(e);
        return "==========deal_hostKey ==== o(╥﹏╥)o";
    }
}
