package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 小吴
 * @Date 2023/01/28 16:01
 * @Version 1.0
 */
//返回结果集
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;       //结果码
    private String  message; //消息
    private T data;    //返回结果

    public CommonResult(Integer code, String message){
        this( code,message,null);
    }
}