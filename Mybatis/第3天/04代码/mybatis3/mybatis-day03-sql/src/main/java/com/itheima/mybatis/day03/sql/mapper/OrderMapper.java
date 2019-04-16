package com.itheima.mybatis.day03.sql.mapper;

import com.itheima.mybatis.day02.crud.model.Order;

import java.util.List;

/**
 * 订单操作类
 */
public interface OrderMapper {
    /**
     * 统计用户下单数.
     *
     * @param id the id
     * @return the integer
     */
    Integer countOrder(Integer id);


    /**
     * 查询所有订单.
     *
     * @return 查询结果
     */
    List<Order> findAll();
}
