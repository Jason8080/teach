package com.itheima.mybatis.day03.pool.model;

import java.util.Date;

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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
