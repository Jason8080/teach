package com.itheima.mybatis.day02.crud.mapper;

import com.itheima.mybatis.day02.crud.model.User;

/**
 * 用户操作类
 */
public interface UserDao {
    /**
     * 查询所有用户.
     *
     * @param id the id
     * @return the user
     */
    User findById(Integer id);
}
