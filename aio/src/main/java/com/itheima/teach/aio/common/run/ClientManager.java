package com.itheima.teach.aio.common.run;



import com.itheima.teach.aio.common.bo.Client;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
     * key: alias
     * value: client
     */
    private static Map<String, Client> clients = new HashMap();


    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get() {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            return it.next().getAsc();
        }
        return null;
    }

    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get(String alias) {
        Client client = clients.get(alias);
        if (client != null) {
            return client.getAsc();
        }
        return null;
    }


    /**
     * 根据asc获取客户端.
     *
     * @param asc the asc
     * @return the client
     */
    public static Client get(AsynchronousSocketChannel asc) {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            Client client = it.next();
            if(asc.equals(client.getAsc())){
                return client;
            }
        }
        return null;
    }

    /**
     * 存储客户端
     *
     * @param asc
     * @return
     */
    public static void put(AsynchronousSocketChannel asc) {
        Client client = new Client(asc);
        clients.put(client.getAlias(), client);
        GroupManager.put(GroupManager.DEFAULT_ID, client);
    }

    /**
     * 关闭客户端
     *
     * @param asc
     * @return
     */
    public static void close(AsynchronousSocketChannel asc) {
        if (asc.isOpen()) {
            try {
                asc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
