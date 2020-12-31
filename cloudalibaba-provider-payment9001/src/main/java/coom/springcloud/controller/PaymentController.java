package coom.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzc
 * @create 2020-12-30 20:33
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return "serverPort: " + serverPort + "\t id:" + id;
    }
}
