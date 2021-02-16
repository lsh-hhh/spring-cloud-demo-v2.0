package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class ConsumerPaymentController {

    @Autowired
    private RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8001/payment";

    @GetMapping("/add")
    public CommonResult create(PaymentEntity paymentEntity) {
        log.info("添加的实例：" + paymentEntity);
        String url = BASE_URL + "/add";
        return restTemplate.postForObject(url, paymentEntity, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        String url = BASE_URL + "/get/" + id;
        return restTemplate.getForObject(url, CommonResult.class);
    }
}
