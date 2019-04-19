package com.itheima.mybatis.day04.a.mapper;

import com.itheima.mybatis.day04.a.model.Order;
import org.apache.ibatis.annotations.Select;

/**
 * 操作类.
 * <p>
 *      用于操作数据库
 * </p>
 */
public interface OrderMapper {

    /**
     * 根据ID查找用户.
     *
     * @param id 参数
     * @return 查询结果 user
     */
    @Select("select * from orders " +
            "where user_id = #{id}")
    Order findById(Integer id);

}