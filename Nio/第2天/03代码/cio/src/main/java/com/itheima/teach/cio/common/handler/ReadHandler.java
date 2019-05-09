package com.itheima.teach.cio.common.handler;

import com.itheima.teach.cio.common.bo.Client;
import com.itheima.teach.cio.common.kit.BufferKit;
import com.itheima.teach.cio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有内容读取将触发该方法
     *
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // 不断读取客户端消息
        ByteBuffer next = BufferKit.getDef();
        asc.read(next, next, new ReadHandler(asc));
        // 根据asc获取客户端
        Client client = ClientManager.get(asc);
        String alias = client != null ? client.getAlias() : "服务端";
        // 处理消息
        String text = new String(buffer.array(), 0, result);
        System.out.println(alias + ": " + text);
    }

    /**
     * 内容读取失败将触发该方法
     *
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        ClientManager.close(asc);
    }
}
