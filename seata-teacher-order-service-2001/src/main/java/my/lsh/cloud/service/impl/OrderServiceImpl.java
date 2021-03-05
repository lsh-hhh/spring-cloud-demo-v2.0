package my.lsh.cloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import my.lsh.cloud.dao.TeacherOrderDao;
import my.lsh.cloud.domain.OrderEntity;
import my.lsh.cloud.service.AccountServiceFeign;
import my.lsh.cloud.service.IOrderService;
import my.lsh.cloud.service.StorageServiceFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private TeacherOrderDao teacherOrderDao;
    @Resource
    private StorageServiceFeign storageService;
    @Resource
    private AccountServiceFeign accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public Long create(OrderEntity orderEntity) {

        log.info("******开始创建订单----> OrderServiceImpl.create" + orderEntity);
        Long result = teacherOrderDao.create(orderEntity);
        log.info("******创建订单完成"  + orderEntity );

        log.info("******开始扣减库存, count----> storageService.decrease");
        storageService.decrease(orderEntity.getProductId(), orderEntity.getCount());
        log.info("******扣减库存完成");

        log.info("******开始扣减账户余额, money----> accountService.decrease" + orderEntity);
        accountService.decrease(orderEntity.getUserId(), orderEntity.getMoney());
        log.info("******账户余额扣减完成");

        log.info("******开始修改订单状态----> update");
        orderEntity.setStatus(1);
        update(orderEntity);
        log.info("******修改订单状态完成");
        return orderEntity.getId();
    }

    @Override
    public OrderEntity findOne(Long id) {
        log.info("查找订单----> findOne， id：" + id);
        return teacherOrderDao.findOne(id);
    }

    @Override
    public Integer update(OrderEntity orderEntity) {
        return teacherOrderDao.update(orderEntity);
    }
}
