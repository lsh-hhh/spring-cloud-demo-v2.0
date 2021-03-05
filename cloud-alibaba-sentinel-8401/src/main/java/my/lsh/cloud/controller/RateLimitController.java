package my.lsh.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import my.lsh.cloud.entities.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    @SentinelResource(value="byResource", blockHandler = "exception_handler")
    @RequestMapping("/byResource")
    public CommonResult byResource(String p){
        return new CommonResult(200, "访问成功，服务正常！", "(～￣▽￣)～ ");
    }

    public CommonResult exception_handler(String p, BlockException be){
        return new CommonResult(444, "访问失败，服务错误！", "(ㄒoㄒ)" + be.getMessage());
    }
}
