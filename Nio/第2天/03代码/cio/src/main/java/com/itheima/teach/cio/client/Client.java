package com.itheima.teach.cio.client;

import com.itheima.teach.cio.common.constant.Address;
import com.itheima.teach.cio.common.constant.Console;
import com.itheima.teach.cio.common.kit.Writer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {

    public static void main(String[] args) throws Exception {
        // 获取连接
        AsynchronousSocketChannel asc = getAsc();

        while (true) {
            // 获取用户输入内容
            String content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 写出内容
            asc = write(asc, buffer);
        }
    }

    private static AsynchronousSocketChannel getAsc() throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();
        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());
        // 因为连接是异步的需要等待连接成功
        Thread.sleep(1000);
        return asc;
    }

    private static AsynchronousSocketChannel write(AsynchronousSocketChannel asc, ByteBuffer buffer) throws Exception {
        // 是否连接可用
        if(!asc.isOpen()){
            // 不可用将重新创建
            asc = getAsc();
            System.out.println("重新连接");
        }
        Writer.write(buffer, asc);
        return asc;
    }
}
