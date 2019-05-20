package com.itheima.teach.cio.common.constant;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * 地址常量.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:32
 * @description : Address
 * @modified : -
 */
public class Address {
    /**
     * 服务器地址.
     */
    public static final SocketAddress loc = new InetSocketAddress("127.0.0.1", 61616);
}
