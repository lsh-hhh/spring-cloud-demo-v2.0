package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment_zk_8005 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment_zk_8005.class, args);
    }
}
