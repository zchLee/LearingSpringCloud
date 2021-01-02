package com.lea.springcloud.entities;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author lzc
 * @create 2021-1-1 15:50
 */
public class DataUtils {

    private static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "111111"));
        hashMap.put(2L, new Payment(2L, "222222"));
        hashMap.put(3L, new Payment(3L, "333333"));
    }

    public static Payment get(Long id) {
        return hashMap.get(id);
    }
}
