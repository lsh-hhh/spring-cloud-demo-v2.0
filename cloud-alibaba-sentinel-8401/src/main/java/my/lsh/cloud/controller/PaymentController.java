package my.lsh.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
//@SentinelResource
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 流控测试
     * @return
     */
    @RequestMapping("/testFlowController")
    public String testFlowController(){
        return "test------> flow controller";
    }

    /**
     * 热点
     * @return
     */
    @SentinelResource(value="testHotKey", blockHandler = "deal_testHotKey")
    @RequestMapping("/testHotKey")
    public String testHotKey(@RequestParam(value="p1", required = false)String p1,
                             @RequestParam(value = "p2", required = false)String p2){
        return "test------> hot key (*^▽^*)";
    }

    public String deal_testHotKey(String p1, String p2, BlockException be){
        return "test------> bad result o(╥﹏╥)o";
    }

}
