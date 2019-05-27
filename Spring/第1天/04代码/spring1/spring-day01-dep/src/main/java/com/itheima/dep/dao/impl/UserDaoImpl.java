package com.itheima.dep.dao.impl;

import com.itheima.dep.dao.UserDao;

/**
 * UserDaoImpl.
 *
 * @author : Jason.lee
 * @version : 1.0
 * @date : 2019/5/10 9:58
 * @description : UserDaoImpl
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存成功");
    }
}
