package com.itheima.teach.chat.common.kit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
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
                        ByteBuffer copy = buffer.duplicate();
                        asc.write(copy, copy, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer result, ByteBuffer content) {
                                if(content.hasRemaining()){
                                    asc.write(content, content, this);
                                }
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer content) {
                                System.out.println("写出失败");
                            }
                        });
                    }
                });
    }
}
