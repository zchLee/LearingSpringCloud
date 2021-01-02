package com.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzc
 * @create 2021-1-1 22:28
 */
@Configuration
@MapperScan("com.springcloud.dao")
public class MyBatisConfig {
}
