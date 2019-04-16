package com.itheima.mybatis.day03.sql.mapper;

import com.itheima.mybatis.day02.crud.model.User;

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


    /**
     * 保存用户.
     *
     * @param user the user
     */
    void saveUser(User user);


    /**
     * 根据部分用户名模糊查询用户.
     *
     * @param username the username
     * @return the list
     */
    List<User> likeByUsername(String username);


    /**
     * 修改用户.
     *
     * @param user the user
     */
    void updateUser(User user);

    /**
     * 删除用户.
     *
     * @param user the user
     */
    void deleteUser(User user);

}
