package com.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;

import java.util.UUID;

/**
 * @author lzc
 * @create 2021-1-1 15:03
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException) {
        return new CommonResult(303, "自定义 global handlerException======1 ");
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return new CommonResult(303, "自定义 global handlerException======2 ");
    }
}
