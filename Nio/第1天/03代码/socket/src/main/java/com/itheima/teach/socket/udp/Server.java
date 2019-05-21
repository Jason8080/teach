package com.itheima.teach.socket.udp;

import com.itheima.teach.socket.Address;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Server.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/12 12:09
 * @description : Server
 * @modified : -
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //1. 创建客户端 并 绑定主机地址
        DatagramSocket socket = new DatagramSocket(Address.loc);
        byte[] bytes = new byte[1024];
        //2. 创建空的集装箱
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //3. 接收数据
        socket.receive(packet);
        //4. 读取集装箱中的数据
        String content = new String(bytes, 0, packet.getLength());
        //5. 打印数据
        System.out.println(content);


        // ==================   回复  ====================
        //1. 准备数据
        byte[] by = "服务端: 收到了".getBytes();
        //2. 创建新的集装箱 并 封装数据 设置 目标地址
        DatagramPacket pack = new DatagramPacket(by, by.length, packet.getAddress(), packet.getPort());
        //3. 发送集装箱
        socket.send(pack);

        // 关闭资源
        socket.close();
    }
}
