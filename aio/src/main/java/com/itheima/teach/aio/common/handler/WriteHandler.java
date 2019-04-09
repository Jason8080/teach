package com.itheima.teach.aio.common.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 写出处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:47
 * @description : WriteHandler
 * @modified : -
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {


    private final AsynchronousSocketChannel asc;

    public WriteHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 写出完成触发该方法
     *
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            asc.write(buffer, buffer, this);
        }
    }

    /**
     * 写出失败时触发该方法
     *
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("写失败了");
    }
}
