package com.itheima.teach.socket.tcp;

import com.itheima.teach.socket.Console;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Task.
 *
 * @author : Jason.lee
 * @version : 1.0
 * @date : 2019/5/22 14:35
 * @description : Task
 */
public class Task {

    public static class Output extends Thread {

        Socket socket;

        public Output(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //1. 获取输出流
                    OutputStream out = socket.getOutputStream();
                    //2. 转换字符串书写流
                    PrintWriter writer = new PrintWriter(out);
                    //3. 输入内容
                    String content = Console.reader.readLine();
                    //4. 书写数据
                    writer.println(content);
                    //5. 冲刷内存
                    writer.flush();
                }
            }catch (Exception e){
                System.out.println("书写数据出错");
                try {
                    //不再写出数据
                    socket.shutdownOutput();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    public static class Input extends Thread {

        Socket socket;

        public Input(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    //1. 获取输入流
                    InputStream in = socket.getInputStream();
                    //2. 转换字符串读取流
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    //4. 打印数据
                    String content;
                    while ((content = reader.readLine()) != null) {
                        SocketAddress remote = socket.getRemoteSocketAddress();
                        System.out.println(remote + ": " + content);
                    }
                }
            }catch (Exception e){
                System.out.println("读取数据出错");
                try {
                    //不再读取数据
                    socket.shutdownInput();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
