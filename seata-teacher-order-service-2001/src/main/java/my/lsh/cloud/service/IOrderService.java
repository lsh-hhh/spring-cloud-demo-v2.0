package my.lsh.cloud.service;

import my.lsh.cloud.domain.OrderEntity;

public interface IOrderService {

    Long create(OrderEntity orderEntity);

    OrderEntity findOne(Long id);

    Integer update(OrderEntity orderEntity);
}
