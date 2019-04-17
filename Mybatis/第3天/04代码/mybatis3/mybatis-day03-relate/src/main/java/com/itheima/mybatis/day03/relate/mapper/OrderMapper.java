package com.itheima.mybatis.day03.relate.mapper;

import com.itheima.mybatis.day03.relate.model.Order;

import java.util.List;

/**
 * 操作类.
 * <p>
 * 用于操作数据库
 * </p>
 */
public interface OrderMapper {
    /**
     * 查找所有订单并显示关联用户信息.
     *
     * @return the list
     */
    List<Order> findAll();
}
