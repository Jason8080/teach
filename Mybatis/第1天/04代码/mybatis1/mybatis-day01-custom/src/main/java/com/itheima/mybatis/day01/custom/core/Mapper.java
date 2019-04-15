package com.itheima.mybatis.day01.custom.core;

/**
 * 映射配置.
 * <p>
 *     封装sql文件userMapper.xml的内容.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/15 20:39
 * @description : Mapper
 * @modified : -
 */
public class Mapper {
    private String namespace;
    private String id;
    private String resultType;
    private String sql;

    @Override
    public String toString() {
        return "Mapper{" +
                "namespace='" + namespace + '\'' +
                ", id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
