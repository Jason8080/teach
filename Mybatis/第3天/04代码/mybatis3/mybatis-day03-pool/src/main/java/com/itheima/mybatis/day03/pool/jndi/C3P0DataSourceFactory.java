package com.itheima.mybatis.day03.pool.jndi;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * 外部连接池实现类.
 * <p>
 *     提供外部数据源的构建方式.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-4-21 16:13
 * @description : C3P0DataSourceFactory
 * @modified : -
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

    public C3P0DataSourceFactory() {
        dataSource = new ComboPooledDataSource();
    }
}
