package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class ConsumerPaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${service.nacos-provider-service}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id){
        String url = serviceUrl + "/payment/nacos/";
        log.info("请求地址：{}", url);
        return restTemplate.getForObject(url + id, String.class);
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return restTemplate.getForObject(serviceUrl + "/payment/echo/" + string, String.class);
    }
}
