package com.itheima.mybatis.day03.relate.model;

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

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDetail='" + roleDetail + '\'' +
                '}';
    }
}
