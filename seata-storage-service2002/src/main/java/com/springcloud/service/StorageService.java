package com.springcloud.service;

/**
 * @author lzc
 * @create 2021-1-1 22:50
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
