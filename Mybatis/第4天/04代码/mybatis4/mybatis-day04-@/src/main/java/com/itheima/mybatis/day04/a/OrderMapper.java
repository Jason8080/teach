package com.itheima.mybatis.day04.a;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

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

    /**
     * 一对一关联查询
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "number", column = "number"),
            @Result(property = "createTime", column = "createtime"),
            @Result(property = "note", column = "note"),
            @Result(property = "user", column = "user_id",
                    one = @One(
                            select = "com.itheima.mybatis.day04.a.mapper.UserMapper.findById",
                            fetchType = FetchType.LAZY))
    })
    List<Order> findO2O();
}