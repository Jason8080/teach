package com.itheima.teach.cio.exterior;

import com.itheima.teach.cio.common.kit.BufferKit;

import java.nio.ByteBuffer;

/**
 * 抽象的单次数据处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/11 10:10
 * @description : AbstractSingleByteBufferHandler
 * @modified : -
 */
public abstract class AbstractSingleByteBufferHandler implements SingleByteBufferHandler {

    /**
     * 完整内容.
     * <p>
     * 当内容超出1024将累积在此.
     * </p>
     */
    ByteBuffer one = ByteBuffer.allocate(0);


    @Override
    public final void handler(Integer result, ByteBuffer buffer) {
        // 合并余留数据
        buffer.flip();
        ByteBuffer all = BufferKit.merge(one, buffer);

        // 处理数据
        int i = singleHandler(result, all);

        // 保存剩余数据
        if(i == -1){
            // 数据不够
            all.rewind();
            one = all;
        }else if(i == 0){
            // 数据刚好
            one = ByteBuffer.allocate(0);
        }else if(i == 1){
            // 数据有多
            one = BufferKit.slice(all);
        }
    }

    /**
     * 处理单次数据.
     * @param result 数据长度
     * @param buffer 数据; 注意: 0和1的情况下必须对缓冲区的position操作
     * @return 数据完整或丢弃返回0, 数据不够返回-1, 数据有余返回1
     */
    protected abstract int singleHandler(Integer result, ByteBuffer buffer);
}
