package com.itheima.teach.socket.udp;

import com.itheima.teach.socket.Address;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Client1.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/12 12:10
 * @description : Client1
 * @modified : -
 */
public class Client {

    public static void main(String[] args) throws Exception {
        //1. 创建客户端
        DatagramSocket socket = new DatagramSocket();
        //2. 准备数据
        byte[] bytes = "客户端: 你好".getBytes();
        //3. 创建集装箱 并 封装数据
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //4. 设置目标地址
        packet.setSocketAddress(Address.loc);
        //5. 发送集装箱
        socket.send(packet);


        //1. 准备新的集装箱
        byte[] by = new byte[1024];
        DatagramPacket pack = new DatagramPacket(by, by.length);
        //2. 接收数据并封装到集装箱
        socket.receive(pack);
        //3. 打印数据
        String content = new String(by, 0, pack.getLength());
        System.out.println(content);

        //关闭资源
        socket.close();
    }
}
