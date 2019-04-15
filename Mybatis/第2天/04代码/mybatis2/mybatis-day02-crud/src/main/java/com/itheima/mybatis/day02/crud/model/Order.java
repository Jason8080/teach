package com.itheima.mybatis.day02.crud.model;

import lombok.Data;

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
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;
}
