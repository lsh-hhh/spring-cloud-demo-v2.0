package my.lsh.cloud.dao;

import my.lsh.cloud.domain.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    Long create(OrderEntity orderEntity);

    OrderEntity findOne(@Param("id") Long id);

    Integer update(OrderEntity orderEntity);
}
