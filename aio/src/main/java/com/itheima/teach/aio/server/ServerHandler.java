package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.kit.BufferKit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接受连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:56
 * @description : ServerHandler
 * @modified : -
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {


    /**
     * 有客户端连接触发该方法
     * @param asc
     * @param server
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
        System.out.println("有链接了"+asc);
        ByteBuffer buffer = BufferKit.getDef();
        asc.read(buffer, buffer, new ReadHandler());
    }


    /**
     * 客户端连接失败触发该方法
     * @param exc
     * @param server
     */
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel server) {
        System.out.println("客户端连接出错了"+exc.getMessage());
    }
}
