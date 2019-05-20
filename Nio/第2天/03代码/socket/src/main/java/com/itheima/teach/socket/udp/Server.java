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
        //① 创建DatagramSocket，指定端口号
        DatagramSocket socket = new DatagramSocket(Address.loc);
        //② 创建DatagramPacket
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //③ 接受客户端发送的数据信息
        socket.receive(packet);
        //④ 读取数据
        String content = new String(bytes, 0, packet.getLength());
        System.out.println(content);


        // ==================   回复  ====================
        byte[] by = "收到了".getBytes();
        // 需要知道客户端的端口
        DatagramPacket pack = new DatagramPacket(by, by.length, packet.getAddress(), packet.getPort());
        socket.send(pack);

    }
}
