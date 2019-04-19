package com.itheima.mybatis.day04.cache.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单类.
 * <p>
 *     用于接收订单表数据.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:20
 * @description : Order
 * @modified : -
 */
public class Order implements Serializable {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;

    private User user;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                ", user=" + user +
                '}';
    }
}
