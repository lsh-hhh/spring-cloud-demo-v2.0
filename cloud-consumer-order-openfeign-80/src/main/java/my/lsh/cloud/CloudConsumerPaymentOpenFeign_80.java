package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CloudConsumerPaymentOpenFeign_80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerPaymentOpenFeign_80.class, args);
    }
}
