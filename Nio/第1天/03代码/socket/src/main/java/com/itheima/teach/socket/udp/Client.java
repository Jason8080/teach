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
        DatagramSocket socket = new DatagramSocket();
        //① 定义发送信息
        byte[] bytes = "客户端: 你好".getBytes();
        //② 创建DatagramPacket，包含将要发送的信息
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        packet.setSocketAddress(Address.loc);
        //③ 发送数据
        socket.send(packet);

        byte[] by = new byte[1024];
        DatagramPacket pack = new DatagramPacket(by, by.length);
        socket.receive(pack);
        String content = new String(by, 0, pack.getLength());
        System.out.println(content);
    }
}
