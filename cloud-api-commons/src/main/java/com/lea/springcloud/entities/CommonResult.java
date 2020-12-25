package com.lea.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzc
 * @create 2020-12-25 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(T data) {
        this(200, " ", data);
    }

    public static CommonResult ok() {
        return new CommonResult(200, "success");
    }

    public static CommonResult error() {
        return new CommonResult(500, "异常");
    }

    public static CommonResult error(String message) {
        return new CommonResult(500, message);
    }
}
