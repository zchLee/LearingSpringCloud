package com.lea.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lzc
 * @create 2020-12-26 21:17
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
