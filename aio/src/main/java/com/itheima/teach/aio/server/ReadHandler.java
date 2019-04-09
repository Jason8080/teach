package com.itheima.teach.aio.server;

import java.nio.ByteBuffer;
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

    /**
     * 有内容读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        System.out.println(new String(buffer.array(), 0, result));
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
