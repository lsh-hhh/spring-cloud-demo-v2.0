package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import my.lsh.cloud.service.PaymentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceI paymentService;

    @PostMapping("/add")
    public CommonResult create(@RequestBody PaymentEntity paymentEntity) {
        log.info("添加的实例：" + paymentEntity);
        Integer i = paymentService.create(paymentEntity);
        if(i > 0){
            log.info("******添加成功！");
            return new CommonResult(200, "添加成功！", i);
        }
        return new CommonResult(200, "添加失败！", 0);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        PaymentEntity payment = paymentService.getPaymentById(id);

        if (payment != null) {
            log.info("******查询成功，结果：" + payment);
            return new CommonResult(200, "查询成功！", payment);
        }
        return new CommonResult(200, "查询失败，无此id：" + id + "的记录！", payment);
    }
}
