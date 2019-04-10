package com.itheima.teach.aio.common.run;

import com.itheima.teach.aio.common.bo.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 群组管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/10 10:51
 * @description : GroupManager
 * @modified : -
 */
public class GroupManager {

    /**
     * 默认群组编号
     */
    public static final String DEFAULT_ID = "CC";

    /**
     * 群组
     */
    private static final Map<String, List<Client>> groups = new HashMap();


    /**
     * 添加客户端.
     *
     * @param key   the key
     * @param value the value
     */
    public static void put(String key, Client value) {
        List<Client> clients = groups.get(key);
        if (clients == null) {
            clients = new ArrayList();
            groups.put(key, clients);
        }
        clients.add(value);
    }


    /**
     * 获取群组内用户.
     *
     * @param key the key
     * @return the list
     */
    public static List<Client> get(String key) {
        List<Client> clients = groups.get(key);
        if (clients != null) {
            return clients;
        }
        return new ArrayList();
    }
}
