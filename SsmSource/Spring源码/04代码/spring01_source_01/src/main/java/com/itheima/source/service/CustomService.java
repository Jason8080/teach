package com.itheima.source.service;

import com.itheima.source.dao.CustomDao;

/**
 * 业务层.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class CustomService {

    CustomDao customDao;

    public void setCustomDao(CustomDao customDao) {
        this.customDao = customDao;
    }

    /**
     * 保存用户.
     */
    public void save(){
        customDao.save();
    }
}
