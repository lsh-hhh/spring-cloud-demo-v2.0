package my.lsh.cloud.bns.service;

import my.lsh.cloud.domain.CommonResult;
import my.lsh.cloud.domain.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("seata-order-service")
public interface OrderServiceFeign {

    @PostMapping("/order/create")
    CommonResult create(OrderEntity orderEntity);
}
