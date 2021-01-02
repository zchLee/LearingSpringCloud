package com.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lzc
 * @create 2021-1-1 22:45
 */
@Mapper
public interface StorageMapper {

    void update(@Param("productId") Long productId, @Param("count") Integer count);

}
