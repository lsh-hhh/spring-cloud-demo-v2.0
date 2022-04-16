package my.lsh.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component
@EnableBinding(Sink.class)
public class MessageReceiveController {

    @Resource
    private SubscribableChannel input;
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        System.out.println("消费者1---->接收到的消息：" + message.getPayload() + "\t 端口号：" + serverPort);
    }
}
