package my.lsh.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@SpringBootApplication
public class CloudProviderPaymentHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPaymentHystrix_8001.class, args);
    }


    /**
     * 半此置是为了原务监控而虎置,与服务容错本身无关, springcloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream",
     * 只要在白已的项日里配置上下面的 servlet就可以了
     * @return
     */
    @Bean
    public ServletRegistrationBean getservlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
