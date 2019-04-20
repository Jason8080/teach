package com.itheima.mybatis.day03.pool.dao.mapper;

import com.itheima.mybatis.day03.pool.dao.model.User;

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


    /**
     * 保存用户.
     *
     * @param user 用户
     */
    void saveUserManual(User user);
    void saveUserAuto(User user);
}
