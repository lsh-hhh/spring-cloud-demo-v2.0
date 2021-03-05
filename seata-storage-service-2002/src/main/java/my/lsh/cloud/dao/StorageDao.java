package my.lsh.cloud.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageDao {
    int decrease(Long productId, Integer count);
}
