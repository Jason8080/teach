package com.itheima.mybatis.day04.cache.mapper;

import com.itheima.mybatis.day04.cache.model.Order;

import java.util.List;

/**
 * 订单操作类
 */
public interface OrderMapper {


    /**
     * 查询所有订单.
     *
     * @return 查询结果
     */
    List<Order> findAll();
}
