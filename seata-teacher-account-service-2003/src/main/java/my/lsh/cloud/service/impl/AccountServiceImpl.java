package my.lsh.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.dao.TeacherAccountDao;
import my.lsh.cloud.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Resource
    private TeacherAccountDao teacherAccountDao;

    @Override
    public Integer decrease(Long userId, BigDecimal money) {
        return teacherAccountDao.decrease(userId, money);
    }
}
