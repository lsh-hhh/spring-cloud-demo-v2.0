package my.lsh.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("my.lsh.cloud.dao")
public class CloudProviderPayment_8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment_8001.class, args);
    }
}
