package my.lsh.cloud.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface TeacherAccountDao {

    Integer decrease(Long userId, BigDecimal money);
}
