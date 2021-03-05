package my.lsh.cloud.service;

import java.math.BigDecimal;

public interface IAccountService {

    Integer decrease(Long userId, BigDecimal money);
}
