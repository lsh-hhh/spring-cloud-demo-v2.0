package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class ConsumerPaymentController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;
    private static final String BASE_URL = "http://cloud-provider-payment-zk";

    @GetMapping("/add")
    public CommonResult create(PaymentEntity paymentEntity) {
        String url = BASE_URL + "/payment/add";
        log.info("添加的实例：" + paymentEntity + " 请求地址：" + url + "\t" + "端口号：" + serverPort);
        return restTemplate.postForObject(url, paymentEntity, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        String url = BASE_URL + "/payment/get/" + id;
        log.info("请求id：" + id + " 请求地址：" + url + "\t" + "端口号：" + serverPort);
        return restTemplate.getForObject(url, CommonResult.class);
    }

    @GetMapping("/discovery")
    public CommonResult discovery(){
        String url = BASE_URL + "/payment/discovery";
        log.info(" 请求地址：" + url + "\t" + "端口号：" + serverPort);
        return restTemplate.getForObject(url, CommonResult.class);
    }
}
