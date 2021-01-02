package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzc
 * @create 2021-1-1 22:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer reside;
}
