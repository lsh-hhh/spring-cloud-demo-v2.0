package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment_consul_8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment_consul_8006.class, args);
    }
}
