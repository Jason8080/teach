package com.itheima.spring.day01.dep.service.impl;

import com.itheima.spring.day01.dep.dao.UserDao;
import com.itheima.spring.day01.dep.dao.impl.UserDaoImpl;
import com.itheima.spring.day01.dep.service.UserService;

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
