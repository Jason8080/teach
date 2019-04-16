package com.itheima.mybatis.day02.dao.mapper;

import com.itheima.mybatis.day02.dao.model.User;

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
