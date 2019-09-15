### 01复习

#### 目标

- 搭建传统开发环境



#### 2. 搭建环境

1. 工程工程: mybatis02_pool_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1.mybatis -->
   <!-- 2.mysql -->
   <!-- 3.log4j -->
   <!-- 4.junit -->
   ```

3. 添加配置: sqlMapConfig.xml

   ```xml
   
   ```

4. 创建实体: com.itheima.pool.User

   ```java
   
   ```

5. 添加映射: com.itheima.pool.UserMapper

   ```java
   
   ```

6. 提供实现: com.itheima.pool.UserMapperImpl

   ```java
   
   ```

7. 映射配置: userMapper.xml

   ```xml
   
   ```

8. 日志配置: log4j.properties

   ```properties
   # 日志级别, 输出位置 
   log4j.rootLogger=DEBUG, stdout
   # 控制台处理器
   log4j.appender.stdout=org.apache.log4j.ConsoleAppender
   # 格式化处理器
   log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
   # 格式化转换器
   log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
   ```

9. 环境测试: ImplTests

   ```java
   
   ```



#### 小结

- 传统开发与代理开发的区别?
  - 



### 02连接池类型【了解】

#### 目标

- 配置内部连接池
- 配置外部连接池





#### 1. 配置内部连接池

1. 内部连接池配置: sqlMapConfig.xml

   ```xml
   
   ```

2. 单元测试: ImplTests

   ```java
   
   ```

3. 无连接池配置: sqlMapConfig.xml

   ```xml
   
   ```

   

#### 2. 配置外部连接池

1. 创建连接池: com.itheima.impl.C3p0DataSourceFactory

   ```java
   
   ```

2. 配置外部连接池: sqlMapConfig.xml

   ```xml
   <!-- 注意名称: driverClass,jdbcUrl -->
   ```

3. 单元测试: ImplTests

   ```java
   
   ```



#### 小结

- 连接池的配置有哪些?
  - 
  - 
  - 





### 03动态SQL - 环境【了解】

#### 目标

- 搭建动态SQL的环境



#### 1. 搭建环境

1. 工程名称: mybatis03_dyn_02

2. 添加依赖: pom.xml

   ```xml
   
   ```

3. 导入配置: sqlMapConfig.xml

   ```xml
   
   ```

4. 导入实体: com.itheima.dyn.User

   ```java
   
   ```

5. 查询用户: com.itheima.dyn.UserMapper

   ```jva
   
   ```

6. 映射配置: userMapper.xml

   ```xml
   
   ```

7. 环境测试: DynTests

   ```java
   
   ```



#### 小结

- 查询参数中的空值会影响查询结果吗?
  - 



### 04动态SQL标签 - if【掌握】

#### 目标

- 使用if标签控制占位符的个数
- 使用if标签实现动态SQL





#### 1. 使用if标签

1. 使用标签: userMapper.xml

   ```java
   
   ```

2. 单元测试: DynTests

   ```xml
   
   ```



#### 小结

- if标签的作用是什么?
  - 
- 如果第2个参数是空会怎样?
  - 



### 05动态SQL标签 - where【掌握】

#### 目标

- 使用where标签解决`,`号个数的问题



#### 1. 使用where标签

1. 使用标签: userMapper.xml

   ```java
   
   ```

2. 单元测试: DynTests

   ```xml
   
   ```



#### 小结

- where标签的作用是什么?
  - 
- 可以同时使用where关键字和标签吗?
  - 



### 06动态SQL标签 - set【掌握】

#### 目标

- 使用set标签解决`,`号个数的问题



#### 1. 使用set标签

1. 修改用户: com.itheima.dyn.UserMapper

   ```java
   
   ```

2. 使用标签: userMapper.xml

   ```java
   
   ```

3. 单元测试: DynTests

   ```xml
   
   ```



#### 小结

- where标签的作用是什么?
  - 
- 可以同时使用set关键字和标签吗?
  - 



### 07动态SQL标签 - sql【了解】

#### 目标

- 使用sql标签定义sql片段



#### 1. 使用sql标签

1. 使用标签: userMapper.xml

   ```xml
   
   ```

2. 单元测试: DynTests

   ```java
   
   ```



#### 小结

- sql和include标签的作用是什么?
  - 



### 08动态SQL标签 - foreach【掌握】

#### 目标

- 使用foreach标签查询部分用户



#### 1. 使用foreach标签

1. 查询部分用户: com.itheima.dyn.UserMapper

   ```java
   
   ```

2. 使用标签: userMapper.xml

   ```xml
   
   ```

3. 单元测试: DynTests

   ```java
   
   ```



#### 小结

- foreach标签的作用是什么?
  - 
- 遍历集合和数组有什么不同?
  - 



### 09关联查询 - O2O【掌握】

#### 目标

- 实现一对一多表查询





#### 1. 一对一关联查询

1. 改造工程: mybatis03_multi_03

2. 创建实体: com.itheima.dyn.Order

   ```java
   
   ```

3. 查询订单: com.itheima.dyn.OrderMapper

   ```java
   
   ```

4. 映射配置: orderMapper.xml

   ```xml
   
   ```

5. 单元测试: ManyTests

   ```java
   
   ```





#### 小结

- 1对1关联可以使用resultType实现吗?
  - 
- ResultMap如何配置关联对象?
  - 









### 10关联查询 - O2M【掌握】

#### 目标

- 实现一对多关联查询



#### 1. 一对多关联查询

1. 改造用户: com.itheima.dyn.User

   ```java
   
   ```

2. 改造映射: userMapper.xml

   ```xml
   
   ```

3. 单元测试: ManyTests

   ```java
   
   ```



#### 小结

- ResultMap如何配置关联集合?
  - 



### 11关联查询 - M2M【掌握】

#### 目标

- 实现多对多关联查询



#### 1. 多对多关联查询

1. 准备数据: 02课前资料/01sql/role.sql

2. 创建角色: com.itheima.dyn.Role

   ```java
   
   ```

3. 改造用户:  com.itheima.dyn.User

   ```java
   
   ```

4. 关联查询: com.itheima.dyn.UserMapper

   ```java
   
   ```

5. 映射配置: userMapper.xml

   ```xml
   
   ```

6. 单元测试: ManyTests

   ```java
   
   ```



#### 小结

- 多对多与1对多有什么不同?
  - 





### 12关联查询 - 注解方式【理解】

#### 目标

- 使用注解实现关联查询



#### 1. 注解实现

1. 改造配置: sqlMapConfig.xml

   ```xml
   
   ```

2. 改造映射: com.itheima.dyn.UserMapper

   ```java
   
   ```

3. 改造映射: com.itheima.dyn.OrderMapper

   ```java
   
   ```

4. 单元测试: ManyTests

   ```java
   
   ```



#### 小结

- @Results的作用?
- 
- @Many的作用?
  - 



### 13关联查询 - 延迟加载【理解】

#### 目标

- 注解实现延迟加载
- 配置实现延迟加载



#### 1. 注解实现延迟加载

1. 改造映射: com.itheima.dyn.OrderMapper

   ```java
   
   ```

2. 单元测试: LazyTests

   ```java
   
   ```



#### 2. 配置实现延迟加载

1. 映射配置: userMapper.xml

   ```xml
   
   ```

2. 单元测试: LazyTests

   ```java
   
   ```



#### 小结

- 延迟后的数据在什么时候加载 (**原理**)?

  - 

  
  
  

### 14总结【了解】

1. 连接池的配置有哪些选项?
   - 
   - 
   - 
2. 什么是动态化SQL?
   - 
3. 至少说出3个动态化SQL标签?
   - 
   - 
   - 
4. 延迟加载的原理是什么?
   - 
5. 传统开发与代理开发的区别?
   - 
6. Mybatis中的方法支持重载吗?
   - 
7. Mybatis框架的特点?
   - 
   - 
   - 