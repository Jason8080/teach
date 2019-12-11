package com.itheima.source.controller;

import com.itheima.source.service.CustomService;

/**
 * 控制层/表现层/视图层.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class CustomController {

    CustomService customService;

    public void setCustomService(CustomService customService) {
        this.customService = customService;
    }

    /**
     * 用户注册.
     */
    public void save(){
        customService.save();
    }
}
