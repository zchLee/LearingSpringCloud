package com.lea.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lzc
 * @create 2020-12-26 20:36
 */
@Component
public class MySelfRule {

    /*
    ribbon 提供了的负载均衡测录
        new RoundRobinRule();  // 轮询
               轮询算法原理  访问次数 % 同服务集群个数 = 下标。 从集群服务中 通过下标获取服务
        new RandomRule();       // 随机
        new RetryRule();        // 先按照RoundRobinRule策略获取服务，如果失败则在指定时间内重试
        new WeightedResponseTimeRule(); // RoundRobinRule 的扩展，响应速度越快，的实例选择权重越大，越容易被选中
        new BestAvailableRule();        // 先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        new AvailabilityFilteringRule();// 先过滤故障实例，再选择并发较小的实例
        new ZoneAvoidanceRule();        // 默认规则，复合判断server所在区域的性能和server的可用性选择服务器

        配置了自定义负载均衡策略后，要在主启动类上加入@RibbonClient注解
     */
    @Bean
    public IRule randomRule() {

        return new RandomRule();
    }
}
