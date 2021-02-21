package my.lsh.cloud.controller;

import my.lsh.cloud.service.MessageProviderServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class sendMessageController {

    @Resource
    private MessageProviderServiceI messageProviderService;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProviderService.send();
    }
}
