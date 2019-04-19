package com.itheima.mybatis.day04.a.mapper;

import com.itheima.mybatis.day04.a.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 操作类.
 * <p>
 *      用于操作数据库
 * </p>
 */
public interface UserMapper {

    /**
     * 根据ID查找用户.
     *
     * @param id 参数
     * @return 查询结果 user
     */
    @Select("select * from user " +
            "where id = #{id}")
    User findById(Integer id);


    /**
     * 保存用户.
     *
     * @param user the user
     */
    @Insert("insert into user(username,birthday,sex,address) " +
            "values(#{username},#{birthday},#{sex},#{address})")
    @SelectKey(statement = "select LAST_INSERT_ID()", resultType = Integer.class,
            keyProperty = "id", keyColumn = "id", before = false)
    void saveUser(User user);

    /**
     * 修改用户.
     *
     * @param user the user
     */
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} " +
            "where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户.
     *
     * @param user the user
     */
    @Delete("delete from user " +
            "where id = #{id}")
    void deleteUser(User user);

    /**
     * 一对多关联查询
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "orders", column = "id",
                    many = @Many(select = "com.itheima.mybatis.day04.a.mapper.OrderMapper.findById"))
    })
    List<User> findO2M();
}