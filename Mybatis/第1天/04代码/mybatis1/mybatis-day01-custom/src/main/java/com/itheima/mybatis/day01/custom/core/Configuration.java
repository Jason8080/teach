package com.itheima.mybatis.day01.custom.core;

/**
 * 主配置文件.
 * <p>
 *     封装数据库文件mybatis.xml文件内容.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/15 20:36
 * @description : Configuration
 * @modified : -
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
