package com.itheima.teach.aio.common.bo;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.UUID;

/**
 * 客户端业务模型.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/10 9:02
 * @description : Client
 * @modified : -
 */
public class Client {
    /**
     * 标识
     */
    private String id = UUID.randomUUID().toString();
    /**
     * 别名
     */
    private String alias = id;
    /**
     * 客户端
     */
    private AsynchronousSocketChannel asc;

    public Client(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AsynchronousSocketChannel getAsc() {
        return asc;
    }

    public void setAsc(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
