package com.springcloud.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lzc
 * @create 2020-12-29 12:03
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("payment_id1",
                r -> r.path("/guonei")
                    .uri("https://news.baidu.com/guonei"));
        routes.route("payment_id2",
                r -> r.path("/lady")
                    .uri("https://news.baidu.com/lady"));
        return routes.build();
    }
}
