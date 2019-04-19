package com.itheima.mybatis.day04.lazy.mapper;

import com.itheima.mybatis.day04.lazy.model.User;

import java.util.List;

/**
 * 操作类.
 * <p>
 * 用于操作数据库
 * </p>
 */
public interface UserMapper {
    /**
     * 查询所有用户.
     * <p>
     * findAll: 操作名称
     * </p>
     *
     * @return 查询结果 list
     */
    List<User> findAll();


    /**
     * 根据ID查找用户.
     *
     * @param id 参数
     * @return 查询结果 user
     */
    User findById(Integer id);

}
