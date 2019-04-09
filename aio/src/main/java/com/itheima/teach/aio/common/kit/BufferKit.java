package com.itheima.teach.aio.common.kit;

import java.nio.ByteBuffer;

/**
 * 缓冲工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:05
 * @description : BufferKit
 * @modified : -
 */
public class BufferKit {
    /**
     * 获取默认大小的缓冲区.
     *
     * @return the byte buffer
     */
    public static ByteBuffer getDef(){
        return ByteBuffer.allocate(1024);
    }
}
