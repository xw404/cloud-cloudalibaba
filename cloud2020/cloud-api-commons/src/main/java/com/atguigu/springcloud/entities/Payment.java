package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 小吴
 * @Date 2023/01/28 15:49
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable {
    private Long id;
    private String serial;
}
