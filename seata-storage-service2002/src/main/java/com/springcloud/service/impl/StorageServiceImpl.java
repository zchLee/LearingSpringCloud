package com.springcloud.service.impl;

import com.springcloud.mapper.StorageMapper;
import com.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lzc
 * @create 2021-1-1 22:50
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("开始减少库存");
        storageMapper.update(productId, count);
        log.info("减少库存完成");

    }
}
