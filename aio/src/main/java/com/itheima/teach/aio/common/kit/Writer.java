package com.itheima.teach.aio.common.kit;

import com.itheima.teach.aio.common.handler.WriteHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

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
     * @param buffer 内容
     * @param asc    客户端
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel asc){
        asc.write(buffer, buffer, new WriteHandler(asc));
    }
}
