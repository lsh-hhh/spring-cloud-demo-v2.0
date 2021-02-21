package my.lsh.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getServerPort")
    public String getServerPort(){
        return "本次启动的服务端口为：" + serverPort;
    }
    @GetMapping("/config")
    public String getAppName(){
        return "本次启动的服务名为：" + appName;
    }
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "本次启动的服务配置信息为：" + configInfo;
    }
}
