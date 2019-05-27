package com.itheima.dep.service.impl;

import com.itheima.dep.dao.impl.UserDaoImpl;
import com.itheima.dep.service.UserService;
import com.itheima.dep.dao.UserDao;

/**
 * UserServiceImpl.
 *
 * @author : Jason.lee
 * @version : 1.0
 * @date : 2019/5/10 10:01
 * @description : UserServiceImpl
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void save() {
        userDao.save();
    }
}
