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
     * 查询id集合中的用户
     *
     * @param ids id集合
     * @return 查询结果 list
     */
    List<User> findByIds(List<Integer> ids);

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
     * @param user 参数对象
     */
    void update(User user);
}
