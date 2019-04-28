package com.itheima.mybatis.day04.a;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作类.
 * <p>
 * 用于操作数据库
 * </p>
 */
public interface OrderMapper {

    /**
     * 根据ID查找用户.
     *
     * @param id 参数
     * @return 查询结果 user
     */
    Order findById(Integer id);

    /**
     * 一对一关联查询
     *
     * @return
     */
    List<Order> findO2O();
}