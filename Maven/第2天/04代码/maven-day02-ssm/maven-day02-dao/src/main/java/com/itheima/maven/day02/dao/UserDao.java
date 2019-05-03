package com.itheima.maven.day02.dao;

import com.itheima.maven.day02.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户持久层.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-5-3 14:15
 * @description : UserDao
 * @modified : -
 */
public interface UserDao {
    /**
     * 查询所有用户.
     *
     * @return 查询结果
     */
    @Select("select * from user")
    List<User> findAll();
}
