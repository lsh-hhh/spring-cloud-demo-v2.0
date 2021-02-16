package my.lsh.cloud.dao;

import my.lsh.cloud.entities.PaymentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int createPayment(PaymentEntity paymentEntity);

    PaymentEntity getPaymentById(@Param("id") Long id);
}
