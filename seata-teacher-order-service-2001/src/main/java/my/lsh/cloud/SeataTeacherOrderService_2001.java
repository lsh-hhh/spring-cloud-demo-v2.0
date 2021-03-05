package my.lsh.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@MapperScan(basePackages = "my.lsh.cloud.dao")
public class SeataTeacherOrderService_2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataTeacherOrderService_2001.class, args);
    }
}
