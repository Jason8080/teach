package com.itheima.mybatis.day03.pool.mapper;

import com.itheima.mybatis.day03.pool.model.User;

/**
 * 用户操作类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-4-21 15:46
 * @description : UserDao
 * @modified : -
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
