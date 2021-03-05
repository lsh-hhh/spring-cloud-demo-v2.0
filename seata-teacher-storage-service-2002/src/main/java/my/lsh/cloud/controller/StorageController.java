package my.lsh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.domain.CommonResult;
import my.lsh.cloud.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        log.info("*****扣减库存开始");
        int decrease = storageService.decrease(productId, count);
        log.info("*****扣减库存结束");
        return new CommonResult(200, "库存扣减成功！", decrease);
    }
}
