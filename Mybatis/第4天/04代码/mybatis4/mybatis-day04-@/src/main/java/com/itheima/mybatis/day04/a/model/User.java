package com.itheima.mybatis.day04.a.model;

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

    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
