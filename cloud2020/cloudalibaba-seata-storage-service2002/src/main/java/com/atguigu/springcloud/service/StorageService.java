package com.atguigu.springcloud.service;

/**
 * @Author 小吴
 * @Date 2023/02/08 14:36
 * @Version 1.0
 */

public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}

