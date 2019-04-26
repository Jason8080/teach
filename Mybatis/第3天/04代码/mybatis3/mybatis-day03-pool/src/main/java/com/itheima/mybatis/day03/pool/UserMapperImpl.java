package com.itheima.mybatis.day03.pool;

import org.apache.ibatis.session.SqlSession;

/**
 * 用户操作接口实现类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-4-26 15:59
 * @description : UserMapperImpl
 * @modified : -
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = SqlSessionKit.openSession();
        User user = sqlSession.selectOne(
                "com.itheima.mybatis.day03.pool.UserMapper.findById", id);
        sqlSession.close();
        return user;
    }
}
