package my.lsh.cloud.service;

import feign.hystrix.FallbackFactory;
import my.lsh.cloud.entities.CommonResult;
import my.lsh.cloud.entities.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallbackFactory implements FallbackFactory<PaymentFeignService> {
    @Override
    public PaymentFeignService create(Throwable throwable) {
        return new PaymentFeignService() {
            @Override
            public CommonResult create(PaymentEntity paymentEntity) {
                return new CommonResult(444, "找不到记录");
            }

            @Override
            public CommonResult getPaymentById(Long id) {
                return new CommonResult(444, "找不到记录");
            }

            @Override
            public CommonResult discovery() {
                return new CommonResult(444, "找不到记录");
            }
        };
    }
}
