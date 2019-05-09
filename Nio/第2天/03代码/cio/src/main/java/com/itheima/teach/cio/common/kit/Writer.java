package com.itheima.teach.cio.common.kit;

import com.itheima.teach.cio.common.handler.WriteHandler;
import com.itheima.teach.cio.common.bo.Client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;
import java.util.Collection;

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
                        ByteBuffer copy = buffer.duplicate();
                        asc.write(copy, copy, new WriteHandler(asc));
                    }
                });
    }

    /**
     * 写出内容到指定客户端.
     *
     * @param buffer  内容
     * @param clients 客户端
     */
    public static void write(ByteBuffer buffer, Collection<Client> clients) {
        clients.forEach(client -> {
            if (client != null && client.getAsc() != null) {
                ByteBuffer copy = buffer.duplicate();
                AsynchronousSocketChannel asc = client.getAsc();
                asc.write(copy, copy, new WriteHandler(asc));
            }
        });
    }
}
