package my.lsh.cloud.dao;

import my.lsh.cloud.domain.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    Integer decrease(Long userId, BigDecimal money);
}
