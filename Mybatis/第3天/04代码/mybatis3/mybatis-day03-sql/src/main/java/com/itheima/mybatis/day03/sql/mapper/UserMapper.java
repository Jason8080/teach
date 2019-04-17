package com.itheima.mybatis.day03.sql.mapper;

import com.itheima.mybatis.day03.sql.model.User;

import java.util.List;

/**
 * 操作类.
 * <p>
 * 用于操作数据库
 * </p>
 */
public interface UserMapper {
    /**
     * 根据多个id查找用户
     *
     * @param ids id数组
     * @return 查询结果 list
     */
    List<User> findByIds(Integer... ids);

    /**
     * 根据用户对象参数查询用户
     *
     * @param user 查询条件对象
     * @return 查询结果 list
     */
    List<User> findBy(User user);

    /**
     * 更新用户.
     *
     * @param user 用户信息
     */
    void update(User user);
}
