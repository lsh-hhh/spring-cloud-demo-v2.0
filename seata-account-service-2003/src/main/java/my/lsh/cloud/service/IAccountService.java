package my.lsh.cloud.service;

import my.lsh.cloud.domain.OrderEntity;

import java.math.BigDecimal;

public interface IAccountService {

    Integer decrease(Long userId, BigDecimal money);
}
