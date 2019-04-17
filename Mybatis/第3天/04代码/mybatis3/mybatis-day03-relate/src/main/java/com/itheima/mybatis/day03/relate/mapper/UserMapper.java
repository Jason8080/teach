package com.itheima.mybatis.day03.relate.mapper;

import com.itheima.mybatis.day03.relate.model.User;

import java.util.List;

/**
 * 操作类.
 * <p>
 * 用于操作数据库
 * </p>
 */
public interface UserMapper {
    /**
     * 查找所有用户并显示关联订单信息.
     *
     * @return the list
     */
    List<User> findAll();
}
