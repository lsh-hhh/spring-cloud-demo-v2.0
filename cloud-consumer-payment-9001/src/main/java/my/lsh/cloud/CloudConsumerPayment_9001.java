package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudConsumerPayment_9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerPayment_9001.class, args);
    }
}
