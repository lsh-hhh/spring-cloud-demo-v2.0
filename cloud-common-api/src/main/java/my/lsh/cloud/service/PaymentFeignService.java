package my.lsh.cloud.service;

import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "CLOUD-PROVIDER-PAYMENT", fallbackFactory = PaymentFeignServiceFallbackFactory.class)
@Component
@RequestMapping("/payment")
public interface PaymentFeignService {

    @PostMapping("/add")
    CommonResult create(@RequestBody PaymentEntity paymentEntity);

    @GetMapping("/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/discovery")
    CommonResult discovery();
}
