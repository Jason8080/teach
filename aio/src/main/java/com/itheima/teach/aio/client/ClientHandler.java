package com.itheima.teach.aio.client;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 客户端连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:40
 * @description : ClientHandler
 * @modified : -
 */
public class ClientHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {


    /**
     * 连接上服务器时触发该方法
     * @param result
     * @param asc
     */
    @Override
    public void completed(Void result, AsynchronousSocketChannel asc) {
        System.out.println("连接成功了"+asc);
    }


    /**
     * 连接失败时触发该方法
     * @param exc
     * @param asc
     */
    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel asc) {
        System.out.println("连接失败了"+exc.getMessage());
    }
}
