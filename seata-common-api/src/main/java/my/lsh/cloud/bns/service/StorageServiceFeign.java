package my.lsh.cloud.bns.service;

import my.lsh.cloud.base.service.BaseService;
import my.lsh.cloud.domain.CommonResult;
import my.lsh.cloud.domain.StorageEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageServiceFeign {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
