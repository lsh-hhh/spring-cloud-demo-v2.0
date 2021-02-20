package my.lsh.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerPaymentHystrixDashboard_9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerPaymentHystrixDashboard_9002.class, args);
    }

}
