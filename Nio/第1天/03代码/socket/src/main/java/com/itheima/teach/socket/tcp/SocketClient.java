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
        //① 创建Socket
        Socket socket = new Socket(Address.loc.getHostName(), Address.loc.getPort());
        //② 打开连接到Socket的输入/输出流
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.print("hello\r\n");
        writer.flush();
        socket.shutdownOutput();
        //③ 按照协议对Socket进行读/写操作
        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String content;
        while ((content = reader.readLine()) != null){
            SocketAddress remote = socket.getRemoteSocketAddress();
            System.out.println(remote + ": " + content);
        }
        socket.shutdownInput();
        //④ 关闭输入输出流、关闭Socket
        socket.close();
    }
}
