package my.lsh.cloud.service;

import my.lsh.cloud.entities.PaymentEntity;

public interface PaymentServiceI {

    int create(PaymentEntity paymentEntity);

    PaymentEntity getPaymentById(Long id);
}
