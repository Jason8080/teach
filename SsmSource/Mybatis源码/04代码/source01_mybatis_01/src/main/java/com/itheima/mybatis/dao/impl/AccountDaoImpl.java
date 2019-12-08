package com.itheima.mybatis.dao.impl;

import com.itheima.mybatis.dao.AccountDao;
import com.itheima.mybatis.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Mybatis传统开发.
 *  - 手动调用API操作数据库
 * @author : Jason.lee
 * @version : 1.0
 */
public class AccountDaoImpl implements AccountDao {

    private SqlSessionFactory sqlSessionFactory;

    public AccountDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void save(Account account) {
        // 1. 获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 执行操作
        sqlSession.insert("com.itheima.mybatis.dao.AccountDao.save", account);
        // 3. 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Account account) {
        // 1. 获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 执行操作
        sqlSession.insert("com.itheima.mybatis.dao.AccountDao.update", account);
        // 3. 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void del(Account account) {
        // 1. 获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 执行操作
        sqlSession.insert("com.itheima.mybatis.dao.AccountDao.del", account);
        // 3. 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Account> findAll() {
        // 1. 获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 执行操作
        // 3. 返回结果
        return sqlSession.selectList("com.itheima.mybatis.dao.AccountDao.findAll");
    }
}
