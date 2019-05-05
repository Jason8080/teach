package com.itheima.maven.day02.domain;

import java.util.Date;

/**
 * 用户类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-5-3 14:04
 * @description : User
 * @modified : -
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

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
}
