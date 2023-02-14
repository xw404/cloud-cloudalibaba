package com.atguigu.springcloud.domain;

import lombok.Data;

/**
 * @Author 小吴
 * @Date 2023/02/08 14:32
 * @Version 1.0
 */

@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
