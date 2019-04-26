package com.itheima.mybatis.day04.cache;

import java.util.List;

/**
 * 操作类.
 * <p>
 *      用于操作数据库
 * </p>
 */
public interface OrderMapper {
    /**
     * 查询所有订单.
     *
     * @return the list
     */
    List<Order> findO2O();
}
