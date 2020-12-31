package com.lea.springcloud.comtroller;

import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.Payment;

import com.lea.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lzc
 * @create 2020-12-25 16:02
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Value(("${spring.application.name}"))
    private String applicationName;

    // 通过此，拿到本服务注册进eureka的注册信息
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("=======插入结果：" + i);
        if (i > 0)
            return new CommonResult(200, "保存成功:"+ serverPort);
        return CommonResult.error();
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        log.info("=======插入结果：" + payment);
        System.out.println(payment);
        if (payment != null)
            return new CommonResult(200, serverPort+ "：查询成功",payment);
        return CommonResult.error("没有找到数据：" + id + "：对应数据不存在");
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> log.info("=======元素：" + s));
        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName.toUpperCase());
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public Object lb() {
        return this.serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e) {}
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public Object zipkin() {
        return "hi, are you ok ?";
    }
}
