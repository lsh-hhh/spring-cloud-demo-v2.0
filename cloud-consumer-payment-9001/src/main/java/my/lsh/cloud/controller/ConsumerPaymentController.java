package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class ConsumerPaymentController {

    @Autowired
    private RestTemplate restTemplate;

//    private final String BASE_URL = "http://localhost:8001/payment";
    private final String BASE_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @GetMapping("/add")
    public CommonResult create(PaymentEntity paymentEntity) {
        String url = BASE_URL + "/payment/add";
        log.info("添加的实例：" + paymentEntity + " 请求地址：" + url);
        return restTemplate.postForObject(url, paymentEntity, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/payment/get/" + id;
        log.info("请求id：" + id + " 请求地址：" + url);
        return restTemplate.getForObject(url, CommonResult.class);
    }
}
