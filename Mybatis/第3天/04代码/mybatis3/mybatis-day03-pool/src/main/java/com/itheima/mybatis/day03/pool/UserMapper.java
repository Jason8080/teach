package com.itheima.mybatis.day03.pool;

/**
 * 操作类.
 * <p>
 *     用于操作数据库.
 * </p>
 */
public interface UserMapper {


    /**
     * 根据ID查找用户.
     *
     * @param id 参数
     * @return 查询结果 user
     */
    User findById(Integer id);
}
