package my.lsh.cloud.service.impl;

import cn.hutool.core.lang.UUID;
import my.lsh.cloud.service.MessageProviderServiceI;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderServiceI {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
         String msg = UUID.fastUUID().toString(true);
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("********massage: " +  msg);
        return msg;
    }
}
