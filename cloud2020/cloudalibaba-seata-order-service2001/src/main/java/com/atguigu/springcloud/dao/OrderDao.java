package com.atguigu.springcloud.dao;
import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @Author 小吴
 * @Date 2023/02/08 12:31
 * @Version 1.0
 */
@Mapper
public interface OrderDao {
    //1新建订单
    public void create(Order order);
    //2修改订单状态（从0改为1）
    public void update(@Param("userId")Long userId,@Param("status")Integer status);
}
