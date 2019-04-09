package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;

import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        // 主线程睡眠1小时
        Thread.sleep(1000*60*60);
    }
}
