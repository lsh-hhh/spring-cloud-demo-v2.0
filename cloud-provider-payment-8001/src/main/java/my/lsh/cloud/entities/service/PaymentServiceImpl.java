package my.lsh.cloud.entities.service;

import my.lsh.cloud.dao.PaymentDao;
import my.lsh.cloud.entities.PaymentEntity;
import my.lsh.cloud.service.PaymentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentServiceI {
    @Autowired
    private PaymentDao dao;
    @Override
    public int create(PaymentEntity paymentEntity) {
        return dao.createPayment(paymentEntity);
    }

    @Override
    public PaymentEntity getPaymentById(Integer id) {
        return dao.getPaymentById(id);
    }
}
