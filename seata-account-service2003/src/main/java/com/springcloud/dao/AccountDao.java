package com.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author lzc
 * @create 2021-1-1 23:00
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}
