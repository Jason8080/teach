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
        //① 创建ServerSocket对象，绑定监听端口
        ServerSocket server = new ServerSocket();
        server.bind(Address.loc);
        //② 通过accept()方法监听客户端请求
        Socket socket = server.accept();
        //③ 连接建立后，通过输入流读取客户端发送的请求信息
        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String content;
        while ((content = reader.readLine()) != null){
            SocketAddress remote = socket.getRemoteSocketAddress();
            System.out.println(remote + ": " + content);
        }
        socket.shutdownInput();
        //④ 通过输出流向客户端发送响应信息
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.print("收到了\r\n");
        writer.flush();
        socket.shutdownOutput();
        //⑤ 关闭相关资源
        socket.close();
    }
}
