### 01复习

#### 目标

- 了解 Spring 相关概念
- 搭建 Spring 项目环境



#### 1. 了解 Spring 相关概念

1. Spring是什么?
   - 
2. Spring IOC是什么?
   - 
3. DI是什么?
   - 



#### 2. 搭建 Spring 项目环境

1. 工程名称: spring02_jdbc_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. Spring IOC依赖 -->
   
   <!-- 2. Spring jdbc依赖 -->
   
   <!-- 3. Mysql 依赖 -->
   
   <!-- 4. Junit 依赖 -->
   
   <!-- 5. Log4j 依赖 -->
   ```

3. 创建实体: com.itheima.jdbc.Account

   ```java
   
   ```

4. 添加配置: applicationContext.xml

   ```xml
   
   ```

5. 日志配置: log4.properties

   ```properties
   # 日志级别, 输出位置
   log4j.rootLogger=DEBUG, stdout
   # 控制台输出器
   log4j.appender.stdout=org.apache.log4j.ConsoleAppender
   # 布局处理器
   log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
   # 格式转换器
   log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
   ```
   
6. 环境测试: JdbcTests.java

   ```java
   
   ```



#### 小结

- 注解与配置的关系是什么?
  - 
- 创建对象的注解有哪些?
  - 

### 02使用Spring-jdbc【掌握】

#### 目标

- 了解Spring-jdbc概念
- 编写JdbcTemplate案例



#### 1. Spring-jdbc概念



#### 2. JdbcTemplate案例





#### 小结

- JdbcTemplate是什么?
  - 
- 案例中如何注入数据源?
  - 





### 03使用IOC管理Jdbc【了解】

#### 目标

- 使用IOC管理Spring-jdbc



#### 1. 使用IOC管理





#### 小结

- IOC中jdbcTemplate在什么时候创建?
  - 
- RowMapper的作用是什么?
  - 



### 04结果集映射器【理解】

#### 目标

- 对象的结果集映射器
- 自定义结果集映射器



#### 1. 对象的结果集映射器

- 类名: org.springframework.jdbc.core.BeanPropertyRowMapper
- 接口: org.springframework.jdbc.core.RowMapper
- 作用: 



#### 2.自定义结果集映射器

1. 外部类: com.itheima.jdbc.AccountRowMapper

   ```java
   
   ```

2. 测试类: JdbcTests

   ```java
   
   ```

3. 内部类: JdbcTests

   ```java
   
   ```



#### 小结

- 自定义结果集映射器的好处是什么?
  - 



### 02完整CRUD - 代码【理解】

#### 目标

- 创建CRUD环境
- 添加CRUD操作



#### 1. 创建CRUD环境

1. 创建工程: spring02_crud_02

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. Spring IOC依赖 -->
   
   <!-- 2. Spring jdbc依赖 -->
   
   <!-- 3. druid连接池依赖 -->
   
   <!-- 4. mysql驱动依赖 -->
   
   <!-- 5. junit单元测试依赖 -->
   ```

#### 2. 添加CRUD操作

1. 实现持久层: com.itheima.crud.dao.impl.AccountDaoImpl

    ```java
    
    ```

2. 实现业务层: com.itheima.crud.service.impl.AccountServiceImpl

    ```java
    
    ```




#### 小结

- 为什么要给jdbcTemplate提供set方法?
  - 
- jdbcTemplate操作是否可以进行测试?
  - 



### 03完整CRUD - 配置【掌握】

#### 目标

- 加载外部配置文件
- 配置IOC依赖注入



#### 1. 加载外部配置文件

1. 添加配置文件: db.properties

   ```properties
   db.driver=com.mysql.jdbc.Driver
   # 针对Mysql 8.x数据库的参数
   #   serverTimezone: 指定时区(UTC)
   #   useSSL: 指定是否使用加密安全连接(false)
   #   allowPublicKeyRetrieval: 是否允许检索公钥(true)
   db.url=jdbc:mysql:///mybatisdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
   db.username=root
   db.password=root
   ```

2. 加载外部文件: applicationContext.xml

   ```xml
   <!--
       context:property-placeholder: 加载指定的资源文件
           location: 本地资源文件路径
   -->
   <context:property-placeholder location="classpath:db.properties"/>
   ```



#### 2. 配置IOC依赖注入

1. 添加配置: applicationContext.xml

    ```xml
    <!-- 1. 配置数据源(连接池) -->
    
    <!-- 2. 配置数据库操作模板对象 -->
    
    <!-- 3. 创建持久层对象 -->
    
    <!-- 4. 创建业务层对象 -->
    ```



#### 小结

- Spring主配置文件中`${}`符号的作用?
  - 

- jdbcTemplate是通过什么方法注入的?
  - 



### 09使用注解改造案例【掌握】

#### 目标

- 使用注解改造CRUD案例工程



#### 1. 改造CRUD案例工程

1. 复制工程: spring02_ax_03

2. 改造持久层: com.itheima.crud.dao.impl.AccountDaoImpl

    ```java
    
    ```

3. 改造业务层: com.itheima.crud.service.impl.AccountServiceImpl

    ```java
    
    ```

4. 添加注解扫描: applicationContext.xml

    ```xml
    
    ```
    
5. 模拟视图层: CrudTests

    ```java
    
    ```



#### 小结

- 为什么accountService名称获取不到对象 ?
  - 



### 10纯注解开发【了解】

#### 目标

- 将剩余的配置使用注解代替
- 掌握纯注解开发的容器创建



#### 1. 使用注解代替剩余配置

- 配置文件的替代注解: @Configuration
- 注解扫描配置的替代注解: @ComponentScan
- 加载配置文件的替代注解: @PropertySource
- 导入配置文件的替代注解: @Import
- 第3方对象创建的替代注解: @Bean

1. com.itheima.crud.SpringConfig

   ```java
   
   ```
   
2. com.itheima.crud.JdbcConfig

   ```java
   
   ```



#### 2. 纯注解开发的容器创建

1. 创建注解实现的容器: AnnoTests

   ```java
   
   ```

   

#### 小结

- 请说出以下注解的作用?
  - @Configuration: 
  - @ComponentScan: 
  - @PropertySource:
  - @Import: 
  - @Bean:



### 11整合Junit框架【了解】

#### 目标

- 了解Junit单元测试的问题
- 了解Spring测试框架的使用



#### 1. Junit单元测试的问题

- 每次测试都需要手动创建IOC容器



#### 2. Spring测试框架的使用

1. 添加依赖: pom.xml

    ```xml
    
    ```

2. 单元测试: SpringTests

    ```java
    
    ```



#### 小结

- @RunWith注解的作用是什么?
  - 
- @ContextConfiguration的作用?
  - 





### 02代理模式【了解】

#### 目标

- 了解什么是代理模式
- 实现静态代理的案例



#### 1. 什么是代理模式

- 提供代理类 **控制(拦截)外部对目标对象的访问** 的一种代码设计

![1562124381705](assets/1562124381705.png) 



#### 2. 静态代理的案例

1. 工程名称: spring02_proxy_04

2. 添加依赖: pom.xml

   ```xml
   <!-- 添加Spring依赖 (Cglib备用) -->
   <!-- 添加Junit依赖 -->
   ```

3. 定义明星接口: com.itheima.proxy.Star

   ```java
   
   ```

4. 创建目标类: com.itheima.proxy.LiuStar

   ```java
   
   ```

5. 创建代理类: com.itheima.proxy.LiuStarProxy

   ```java
   
   ```

6. 单元测试: LiuStarProxyTests.java

   ```java
   // 【静态代理的特点】
   // 1. 代理类需要在代码运行前创建
   // 2. 代理类内部需要维护目标对象
   // 3. 代理类要实现目标对象的接口
   ```



#### 小结

- 什么是代理模式?
  - 
- 目标对象是哪个?
  - 
- 代理对象是哪个?
  - 
- 静态代理的特点?
  - 
  - 
  - 



### 03动态代理-jdk【理解】

#### 目标

- 了解动态代理的特点
- 实现jdk动态代理案例



#### 1. 动态代理的特点

- 代理类在代码运行时创建



#### 2. jdk动态代理案例

1. 官网API (Proxy)

   ```java
   public static Object newProxyInstance(
      						// 1. 类加载器
                           ClassLoader loader,
       					// 2. 代理对象需要实现的接口数组
                           Class<?>[] interfaces,
       					// 3. 代理对象方法调用时的处理器
                           InvocationHandler h
   ) throws IllegalArgumentException
   ```

2. 单元测试: LiuStarProxyTests.java

   ```java
   // 1. 创建目标对象
   
   // 2. 创建代理对象
   
   // 3. 使用代理对象
   ```



#### 小结

- 动态代理有什么特点?
  - 
- 使用jdk动态代理对目标对象有什么要求?
  - 



### 04动态代理-cglib【理解】

#### 目标

- cglib动态代理的案例
- 两种动态代理的区别



#### 1. cglib动态代理的案例

1. 添加依赖: pom.xml

   ```xml
   <!-- 添加Cglib实现 (Spring已整合) -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>5.0.2.RELEASE</version>
   </dependency>
   ```

2. 官网API (Enhancer)

   ```java
   public static Object create(
       					// 1. 代理对象需要继承的类
                           java.lang.Class superclass,
   						// 2. 代理对象需要实现的接口
                           java.lang.Class[] interfaces,
   						// 3. 代理对象方法调用时的处理器 InvocationHandler
                           Callback[] callbacks
   )
   ```

3. 单元测试: LiuStarProxyTests.java

   ```java
   
   ```



#### 2. 两种动态代理的区别

|          | JDK                                           | CGLIB                                    |
| -------- | --------------------------------------------- | ---------------------------------------- |
| 实现方式 | 利用 **实现** 接口方法来拦截目标方法          | 利用 **继承** 覆写方法来拦截目标方法     |
| 性能高低 | JDK1.6以前较Cglib慢; 1.6以及1.7大量调用时较慢 | 1.8时被JDK代理超越                       |
| 适用场景 | 目标对象必须实现接口                          | 目标方法需要允许覆写(不能用final/static) |



#### 小结

- 常见的动态代理有哪些?
  - 

- 两种动态代理有什么区别?
  - 
  - 









### 12总结

1. 纯注解开发涉及哪些注解?
   - 
   - 
   - 
   - 
   - 
2. Spring-test涉及哪些注解?
   - 
   - 
3. 什么是代理模式?
   - 
4. 静态代理和动态代理的区别?
   - 
5. 两种动态代理的区别?
   - 

