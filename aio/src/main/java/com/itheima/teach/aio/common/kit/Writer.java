package com.itheima.teach.aio.common.kit;

import com.itheima.teach.aio.common.handler.WriteHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;

/**
 * 写出工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 17:19
 * @description : Writer
 * @modified : -
 */
public class Writer {
    /**
     * 写出内容到指定客户端.
     *
     * @param buffer  内容
     * @param clients 客户端
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel... clients) {
        Arrays.stream(clients)
                .forEach(asc -> {
                    if (asc != null) {
                        asc.write(buffer, buffer, new WriteHandler(asc));
                    }
                });
    }
}
