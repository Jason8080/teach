package com.itheima.teach.socket.tcp;

import com.itheima.teach.socket.Address;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Socket服务端.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/12 11:27
 * @description : Socket
 * @modified : -
 */
public class SocketServer {

    public static void main(String[] args) throws Exception {
        //1. 创建服务端
        ServerSocket server = new ServerSocket();
        //2. 绑定主机地址
        server.bind(Address.loc);
        //3. 监听客户端请求
        Socket socket = server.accept();
        //4. 读取数据
        new Task.Output(socket).start();
        //5. 回复数据
        new Task.Input(socket).start();
    }
}
