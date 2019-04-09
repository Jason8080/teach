package com.itheima.teach.aio.common.handler;

import com.itheima.teach.aio.common.kit.BufferKit;

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
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // 不断读取客户端消息
        ByteBuffer next = BufferKit.getDef();
        asc.read(next, next, new ReadHandler(asc));
        // 处理消息
        String text = new String(buffer.array(), 0, result);
        System.out.println(text);
        // 处理信息后回复消息
//        ByteBuffer content = ByteBuffer.wrap("收到: ".concat(text).getBytes());
//        asc.write(content, content, new WriteHandler(asc));
    }

    /**
     * 内容读取失败将触发该方法
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("读取失败");
    }
}
