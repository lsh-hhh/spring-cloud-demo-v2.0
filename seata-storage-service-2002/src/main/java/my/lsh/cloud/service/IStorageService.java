package my.lsh.cloud.service;

import my.lsh.cloud.domain.OrderEntity;

public interface IStorageService {

    int decrease(Long productId, Integer count);
}
