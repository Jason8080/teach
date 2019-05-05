package com.itheima.maven.day02.service;

import com.itheima.maven.day02.dao.UserDao;
import com.itheima.maven.day02.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务中心.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-5-3 14:20
 * @description : UserService
 * @modified : -
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }
}
