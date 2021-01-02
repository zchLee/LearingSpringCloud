package com.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lzc
 * @create 2021-1-1 22:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
