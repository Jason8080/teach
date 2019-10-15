### 01复习

#### 目标

- 了解常见的面试题
- 搭建 IOC 项目环境



#### 1. 了解常见的面试题

##### 1.1 请说说你对Spring的理解

- 



##### 1.2 什么是IOC

- 



##### 1.3 什么是DI

- 



#### 2. 搭建Spring项目环境

1. 工程名称: spring02_crud_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. Spring IOC依赖 -->
   
   <!-- 2. Spring jdbc依赖 -->
   
   <!-- 3. druid连接池依赖 -->
   
   <!-- 4. mysql驱动依赖 -->
   
   <!-- 5. junit单元测试依赖 -->
   ```

3. 创建实体: com.itheima.crud.Account

   ```java
   
   ```

4. 添加配置: applicationContext.xml

   ```xml
   
   ```

5. 环境测试: CrudTests.java

   ```java
   
   ```



#### 小结

- Spring是什么?
  - 
- IOC是什么?
  - 
- DI是什么?
  - 



### 02实现CRUD - 代码【理解】

#### 目标

- 使用jdbcTemplate实现CRUD操作



#### 1. 实现CRUD操作

1. 实现持久层: com.itheima.crud.dao.impl.AccountDaoImpl

    ```java
    
    ```

2. 实现业务层: com.itheima.crud.service.impl.AccountServiceImpl

    ```java
    
    ```

3. 模拟视图层: CrudTests

    ```java
    // 只编写测试代码, 需要配置IOC之后方能进行测试
    
    
    ```



#### 小结

- 为什么要给jdbcTemplate提供set方法?
  - 



### 03实现CRUD - 配置【掌握】

#### 目标

- 实现IOC依赖注入
- 加载外部配置文件



#### 1. 实现IOC依赖注入

1. 添加配置: applicationContext.xml

    ```xml
    <!-- 1. 配置数据源(连接池) -->
    
    <!-- 2. 配置数据库操作模板对象 -->
    
    <!-- 3. 创建持久层对象 -->
    
    <!-- 4. 创建业务层对象 -->
    ```



#### 2. 加载外部配置文件

1. 添加配置文件: db.properties

    ```properties
    db.driver=com.mysql.cj.jdbc.Driver
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



#### 小结

- jdbcTemplate是通过什么方法注入的?
  - 
- Spring主配置文件中`${}`符号的作用?
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





### 12总结

- 今天的新内容就是19个注解 .
- 请描述下列19个注解的作用 ?

#### 1. 创建对象 (4个)

- 

- 
- 
- 

#### 2. 依赖注入 (4个)

- 
- 
- 
- 

#### 3. 生命周期 (4个)

- 
- 
- 
- 

#### 4. 纯注解　 (5个)

- 
- 
- 
- 
- 

#### 5. 单元测试 (2个)

- 
- 

