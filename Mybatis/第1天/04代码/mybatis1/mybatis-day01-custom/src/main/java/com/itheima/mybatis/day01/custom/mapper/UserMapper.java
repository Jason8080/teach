package com.itheima.mybatis.day01.custom.mapper;

import com.itheima.mybatis.day01.custom.model.User;

import java.util.List;

/**
 * 操作类.
 * <p>
 *     用于操作数据库.
 * </p>
 */
public interface UserMapper {
    /**
     * 查询所有用户.
     * <p>
     *     findAll: 操作名称
     * </p>
     * @return 查询结果
     */
    List<User> findAll();
}
