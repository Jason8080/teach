package com.itheima.source.service;

import com.itheima.source.dao.CustomDao;

/**
 * 业务层.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class CustomService {
    public CustomService() {
        System.out.println("Service init finish..");
    }

    CustomDao customDao;

    public void setCustomDao(CustomDao customDao) {
        System.out.println("Service Di ing..");
        this.customDao = customDao;
    }

    /**
     * 保存用户.
     */
    public void save(){
        customDao.save();
    }
}
