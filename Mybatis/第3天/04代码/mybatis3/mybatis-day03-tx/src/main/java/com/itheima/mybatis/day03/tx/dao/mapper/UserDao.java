package com.itheima.mybatis.day03.tx.dao.mapper;

import com.itheima.mybatis.day03.tx.dao.model.User;

/**
 * 用户操作类
 */
public interface UserDao {
    /**
     * 保存用户.
     *
     * @param user 用户
     */
    void saveUser(User user);
}
