package com.itheima.teach.socket.udp;

import com.itheima.teach.socket.Address;
import com.itheima.teach.socket.Console;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

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

        for (int i = 0; true; i++) {

            byte[] bytes = new byte[1024];
            //2. 创建空的集装箱
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            //3. 接收数据
            socket.receive(packet);
            //4. 读取集装箱中的数据
            String req = new String(bytes, 0, packet.getLength());
            //5. 打印数据
            System.out.println(req);

            // ----------------------------------------------

            //      获取控制台1行输入
            String content = Console.reader.readLine();
            if("stop".equals(content)){
                break;
            }

            //1. 准备数据
            byte[] bs = "服务端: ".concat(content).getBytes();
            //2. 创建新的集装箱 并 封装数据 设置 目标地址
            DatagramPacket pack = new DatagramPacket(bs, bs.length, packet.getAddress(), packet.getPort());
            //3. 发送集装箱
            socket.send(pack);

        }

        // 关闭资源
        socket.close();
    }
}
