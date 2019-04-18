package com.itheima.mybatis.day02.lazy.mapper;

import com.itheima.mybatis.day02.lazy.model.Order;

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
