package my.lsh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosProvider_9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosProvider_9002.class, args);
    }
}
