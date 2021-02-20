package my.lsh.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import my.lsh.cloud.service.PaymentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceI paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/add")
    public CommonResult create(@RequestBody PaymentEntity paymentEntity) {
        log.info("添加的实例：" + paymentEntity);
        Integer i = paymentService.create(paymentEntity);
        if(i > 0){
            log.info("******添加成功，端口号为:" + serverPort);
            return new CommonResult(200, "添加成功！", i);
        }
        return new CommonResult(444, "添加失败！", 0);
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentByIdHandler")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        PaymentEntity payment = paymentService.getPaymentById(id);

        if (payment == null) {
            throw new RuntimeException("查询失败");
        }
        log.info("******查询成功，端口号为:" + serverPort + "， 结果：" + payment);
        return new CommonResult(200, "查询成功！", payment);
    }

    /**
     * 异常处理方法
     * @param id
     * @return
     */
    public CommonResult getPaymentByIdHandler(@PathVariable("id") Long id){
        return new CommonResult(444, "o(╥﹏╥)o  查询失败，无此id：" + id + "的记录！", null);
    }

    @GetMapping("/discovery")
    public CommonResult discovery(){
        List<String> services = discoveryClient.getServices();
        log.info("所有注册的服务：" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        return new CommonResult(200, "微服务cloud-provider-payment信息", instances);
    }
}
