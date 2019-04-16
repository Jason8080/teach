package com.itheima.mybatis.day02.dao.mapper.impl;

import com.itheima.mybatis.day02.dao.kit.SqlSessionKit;
import com.itheima.mybatis.day02.dao.mapper.UserDao;
import com.itheima.mybatis.day02.dao.model.User;
import org.apache.ibatis.session.SqlSession;

/**
 * 用户操作实现类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:55
 * @description : UserDaoImpl
 * @modified : -
 */
public class UserDaoImpl implements UserDao{
    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = SqlSessionKit.openSession();
        User user = sqlSession.selectOne("test.queryById", id);
        sqlSession.close();
        return user;
    }
}
