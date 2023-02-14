package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 小吴
 * @Date 2023/02/08 13:20
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)   //事务回滚
    public void create(Order order) {
        /**
         * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
         * 简单说：
         * 下订单->减库存->减余额->改状态
         */
        //1
        log.info("-------新建订单");
        orderDao.create(order);
        //2
        log.info("---------订单微服务开始调用库存做扣减操作");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---------订单微服务开始调用库存做扣减操作  已经结束");
        //3
        log.info("---------订单微服务开始调用账户扣钱操作");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---------订单微服务开始调用账户扣钱操作    已经结束");
        //4
        log.info("---------修改订单的状态    从0到1");
        orderDao.update(order.getUserId(),0);
        log.info("---------修改订单的状态    从0到1   已经结束");

        log.info("下订单结束了");
    }
}
