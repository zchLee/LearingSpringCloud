package springcloud.controller;

import com.lea.springcloud.entities.CommonResult;
import com.lea.springcloud.entities.DataUtils;
import com.lea.springcloud.entities.Payment;
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

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getServerPort(@PathVariable("id") Long id) {
        CommonResult<Payment> result = new CommonResult<>(200,
                "serverPort: " + serverPort + "\t id:" + id,
                DataUtils.get(id));
        return result;
    }
}
