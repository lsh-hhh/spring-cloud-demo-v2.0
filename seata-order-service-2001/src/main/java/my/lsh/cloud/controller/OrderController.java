package my.lsh.cloud.controller;

import my.lsh.cloud.domain.CommonResult;
import my.lsh.cloud.domain.OrderEntity;
import my.lsh.cloud.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(OrderEntity orderEntity){
        Long aLong = orderService.create(orderEntity);

        return new CommonResult(200, "订单添加成功", aLong);
    }
}
