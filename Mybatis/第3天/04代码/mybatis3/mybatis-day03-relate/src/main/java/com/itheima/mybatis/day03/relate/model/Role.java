package com.itheima.mybatis.day03.relate.model;

import java.util.List;

/**
 * 角色类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/17 14:29
 * @description : Role
 * @modified : -
 */
public class Role {
    private Long roleId;
    private String roleName;
    private String roleDetail;

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDetail='" + roleDetail + '\'' +
                ", users=" + users +
                '}';
    }
}
