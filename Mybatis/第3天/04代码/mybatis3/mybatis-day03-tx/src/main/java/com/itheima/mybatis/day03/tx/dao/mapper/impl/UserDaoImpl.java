package com.itheima.mybatis.day03.tx.dao.mapper.impl;

import com.itheima.mybatis.day03.tx.dao.kit.SqlSessionKit;
import com.itheima.mybatis.day03.tx.dao.mapper.UserDao;
import com.itheima.mybatis.day03.tx.dao.model.User;
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
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUserManual(User user) {
        SqlSession sqlSession = SqlSessionKit.openSession();
        sqlSession.insert("test.save", user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Override
    public void saveUserAuto(User user) {
        SqlSession sqlSession = SqlSessionKit.openSession(true);
        sqlSession.insert("test.save", user);
        sqlSession.close();
    }
}
