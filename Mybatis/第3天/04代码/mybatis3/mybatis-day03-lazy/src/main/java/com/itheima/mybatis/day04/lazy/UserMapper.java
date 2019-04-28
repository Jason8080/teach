package com.itheima.mybatis.day04.lazy;

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
     *
     * @return the list
     */
    List<User> findO2M();
}
