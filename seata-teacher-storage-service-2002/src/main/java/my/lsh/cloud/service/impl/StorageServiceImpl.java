package my.lsh.cloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.dao.TeacherStorageDao;
import my.lsh.cloud.service.IStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements IStorageService {

    @Resource
    private TeacherStorageDao teacherStorageDao;

    public int decrease(Long productId, Integer count){
        return teacherStorageDao.decrease(productId, count);
    }

}
