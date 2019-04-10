package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.kit.Console;
import com.itheima.teach.aio.common.kit.Writer;
import com.itheima.teach.aio.common.run.GroupManager;
import com.itheima.teach.aio.common.bo.Client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.List;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 获取客户端
            List<Client> clients = GroupManager.get(GroupManager.DEFAULT_ID);
            // 写出内容
            Writer.write(buffer, clients);
        }
    }
}
