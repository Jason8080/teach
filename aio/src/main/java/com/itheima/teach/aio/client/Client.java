package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.constant.Address;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());

        // 准备内容
        ByteBuffer buffer = ByteBuffer.wrap("666".getBytes());

        // 写出内容
        asc.write(buffer, buffer, new WriteHandler());
    }
}
