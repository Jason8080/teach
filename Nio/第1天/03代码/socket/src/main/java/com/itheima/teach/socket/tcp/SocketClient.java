package com.itheima.teach.socket.tcp;

import com.itheima.teach.socket.Address;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Socket客户端.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/12 11:27
 * @description : Socket
 * @modified : -
 */
public class SocketClient {

    public static void main(String[] args) throws Exception {
        //1. 创建客户端
        Socket socket = new Socket(Address.loc.getHostName(), Address.loc.getPort());
        //2. 书写数据
        new Task.Output(socket).start();
        //3. 读取数据
        new Task.Input(socket).start();
    }
}
