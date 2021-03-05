package my.lsh.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.bns.service.AccountServiceFeign;
import my.lsh.cloud.bns.service.StorageServiceFeign;
import my.lsh.cloud.dao.StorageDao;
import my.lsh.cloud.domain.OrderEntity;
import my.lsh.cloud.service.IStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements IStorageService {

    @Resource
    private StorageDao storageDao;

    public int decrease(Long productId, Integer count){
        return storageDao.decrease(productId, count);
    }

}
