package com.itheima.mybatis.day03.pool.mapper.impl;

import com.itheima.mybatis.day03.pool.kit.SqlSessionKit;
import com.itheima.mybatis.day03.pool.mapper.UserDao;
import com.itheima.mybatis.day03.pool.model.User;
import org.apache.ibatis.session.SqlSession;

/**
 * UserDaoImpl.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-4-21 15:48
 * @description : UserDaoImpl
 * @modified : -
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findById(Integer id) {
        // 打开链接
        SqlSession sqlSession = SqlSessionKit.openSession(false);
        // 执行操作
        User user = sqlSession.selectOne("test.queryById", id);
        // 关闭资源
        sqlSession.close();
        return user;
    }

    @Override
    public void saveUserManual(User user) {
        SqlSession sqlSession = SqlSessionKit.openSession(false);
        sqlSession.insert("test.saveUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void saveUserAuto(User user) {
        SqlSession sqlSession = SqlSessionKit.openSession(true);
        sqlSession.insert("test.saveUser", user);
        sqlSession.close();
    }


}
