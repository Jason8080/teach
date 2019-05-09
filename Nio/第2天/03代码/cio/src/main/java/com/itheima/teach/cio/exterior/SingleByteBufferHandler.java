package com.itheima.teach.cio.exterior;

import java.nio.ByteBuffer;

/**
 * 单次原始内容处理器.
 * <p>
 * 数据大小不超过1024,超出将分批处理.
 * </p>
 */
public interface SingleByteBufferHandler {
    /**
     * 处理数据.
     * <p>
     * 处理后返回剩余数据.
     * 单次数据不超过1024.
     * </p>
     *
     * @param result 数据长度
     * @param buffer 目标数据
     */
    void handler(Integer result, ByteBuffer buffer);
}
