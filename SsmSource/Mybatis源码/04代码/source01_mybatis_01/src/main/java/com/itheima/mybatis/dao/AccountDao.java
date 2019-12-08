package com.itheima.mybatis.dao;

import com.itheima.mybatis.domain.Account;

import java.util.List;

/**
 * 账户持久层接口.
 *  Mybatis开发方式:
 *      1. 传统方式
 *      2. 代理方式
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public interface AccountDao {


    /**
     * 保存账户.
     *
     * @param account 账户信息
     */
    void save(Account account);

    /**
     * 修改账户.
     *
     * @param account 账户信息
     */
    void update(Account account);

    /**
     * 删除账户.
     *
     * @param account 账户信息
     */
    void del(Account account);

    /**
     * 查询所有账户.
     *
     * @return 查询结果
     */
    List<Account> findAll();

}
