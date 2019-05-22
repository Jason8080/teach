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
@SuppressWarnings("ALL")
public class SocketClient {

    public static void main(String[] args) throws Exception {
        //1. 创建客户端 Socket
        Socket socket = new Socket(Address.loc.getHostName(), Address.loc.getPort());
        //2. 打开连接, 获取到输出流
        OutputStream out = socket.getOutputStream();
        //      转换字符串书写流
        PrintWriter writer = new PrintWriter(out);
        //      可以使用println("hello")代替
        writer.print("hello\r\n");
        //3. 冲刷内存
        writer.flush();
        //      不再写出数据
        socket.shutdownOutput();

        // ----------------------------------------------

        //1. 获取到输入流
        InputStream in = socket.getInputStream();
        //      转换字符串读取流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //2. 打印数据
        String content;
        while ((content = reader.readLine()) != null){
            SocketAddress remote = socket.getRemoteSocketAddress();
            System.out.println(remote + ": " + content);
        }
        //      不再读取数据
        socket.shutdownInput();
        //关闭资源
        socket.close();
    }
}
