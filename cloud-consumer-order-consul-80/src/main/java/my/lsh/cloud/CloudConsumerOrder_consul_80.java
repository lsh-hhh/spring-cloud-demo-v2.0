package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrder_consul_80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder_consul_80.class, args);
    }
}
