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
@SuppressWarnings("ALL")
public class SocketServer {

    public static void main(String[] args) throws Exception {
        //1. 创建服务端 Socket
        ServerSocket server = new ServerSocket();
        //      绑定主机地址
        server.bind(Address.loc);
        //2. 监听客户端请求
        Socket socket = server.accept();
        //3. 连接建立后，获取输入流
        InputStream in = socket.getInputStream();
        //      转换字符串读取流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //4. 打印数据
        String content;
        while ((content = reader.readLine()) != null){
            SocketAddress remote = socket.getRemoteSocketAddress();
            System.out.println(remote + ": " + content);
        }
        //      不再读取数据
        socket.shutdownInput();

        // ----------------------------------------------

        //1. 获取输出流
        OutputStream out = socket.getOutputStream();
        //      转换字符串书写流
        PrintWriter writer = new PrintWriter(out);
        //2. 书写数据
        writer.print("收到了\r\n");
        //3. 冲刷内存
        writer.flush();
        //      不再写出数据
        socket.shutdownOutput();
        //关闭资源
        socket.close();
    }
}
