package my.lsh.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.dao.AccountDao;
import my.lsh.cloud.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Integer decrease(Long userId, BigDecimal money) {
        return accountDao.decrease(userId, money);
    }
}
