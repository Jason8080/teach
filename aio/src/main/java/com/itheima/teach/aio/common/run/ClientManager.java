package com.itheima.teach.aio.common.run;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:31
 * @description : ClientManager
 * @modified : -
 */
public class ClientManager {

    /**
     * 客户端
     */
    private static AsynchronousSocketChannel client = null;


    /**
     * 获取客户端
     * @return
     */
    public static AsynchronousSocketChannel get(){
        return client;
    }

    /**
     * 存储客户端
     * @param asc
     * @return
     */
    public static AsynchronousSocketChannel put(AsynchronousSocketChannel asc){
        return client = asc;
    }
}
