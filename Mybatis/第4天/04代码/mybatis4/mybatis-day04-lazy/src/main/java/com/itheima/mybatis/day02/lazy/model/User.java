package com.itheima.mybatis.day02.lazy.model;

import java.util.Date;
import java.util.List;

/**
 * 用户类.
 * <p>
 *     用于封装数据表里的数据
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/5 14:42
 * @description : User
 * @modified : -
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    List<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
