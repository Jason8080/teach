### 01复习

#### 目标

- 了解常见的面试题
- 搭建 IOC 项目环境



#### 1. 了解常见的面试题

##### 1.1 请说说你对Spring的理解

- Spring是一个分层的轻量级开源框架
- 核心功能是IOC 和 AOP 并且支持声明式事务
- 是一个扩展性很好的开放型框架 (对很多优秀框架有直接的支持, 整合其他框架非常方便)

##### 1.2 什么是IOC

- IOC(Inversion Of Control)是控制反转思想的简写
- 控制反转指的是将创建对象的行为转交给IOC的工厂完成
- IOC的好处包括解耦, 支持单例模式, 支持依赖注入等

##### 1.3 什么是DI

- DI(Dependency Injection)是依赖注入的简写
- 依赖注入是IOC给对象赋值的一项功能 (从而做到管理依赖关系)



#### 2. 搭建Spring项目环境

1. 工程名称: spring-day03-crud

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

5. 单元测试: CrudTests.java

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



### 04基于注解创建对象【掌握】

#### 目标

- 使用@Component注解创建对象



#### 1. 使用注解创建对象

1. 工程名称: spring-day02-anno

2. 添加依赖: pom.xml

    ```xml
    
    ```

3. 创建实体: com.itheima.anno.Account

    ```java
    
    ```

4. 添加配置: applicationContext.xml

    ```xml
    
    ```

5. 单元测试: AnnoTests

    ```java
    
    ```





#### 小结

- @Component的作用?
  - 

- 使用注解需要写什么配置?
  - 



### 05创建对象的注解【掌握】

#### 目标

- 创建对象的其他注解



#### 1. 创建对象的其他注解

- 为了在3层架构中识别不同层的对象延伸了3个注解

1. 注解演示: com.itheima.anno.Account

    ```java

    ```



#### 小结

- 在3层架构中延伸出了哪3个注解?
  - 



### 06依赖注入的注解【掌握】

#### 目标

- 了解依赖注入的前提
- 使用依赖注入的注解



#### 1. 依赖注入的前提

- 需要将对象交由IOC容器管理



#### 2. 使用注解注入值

1. 创建实体: com.itheima.anno.User

    ```java
    // 1. 使用@Autowired修饰username: 演示注入username对象
    
    // 2. 使用@Qualifier修饰username: 演示注入指定名称的对象
    
    // 3. 使用@Resource修饰address: 代替@Autowired+@Qualifier
    
    // 4. 使用@Value修饰sex: 注入基本数据类型参数值
    ```

2. 配置对象: applicationContext.xml

    ```xml
    <!-- 配置username对象 -->
    ```
    
3. 单元测试: AnnoTests

    ```java
    
    ```



#### 小结

- 使用依赖注入的前提是什么?
  - 
- 赋值(依赖注入)的注解有哪几个?
  - 
  - 
  - 
  - 



### 07生命周期的注解【了解】

#### 目标

- 了解生命周期的相关概念
- 了解生命周期的相关注解



#### 1. 生命周期的相关概念

- 生命周期: 对象的创建到销毁的过程
- 如: 创建、创建后、销毁前、销毁



#### 2. 生命周期的相关注解

1. 注解演示: com.itheima.anno.Account

    ```java
    
    ```

2. 单元测试: AnnoTests

    ```java
    
    ```



#### 小结

- 影响对象生命周期的注解有哪些?
  - 
  - 
  - 
  - 



### 08注解与配置的关系【了解】

#### 目标

- 了解注解和配置的关系



#### 1. 注解和配置的关系

- 注解是配置的代替方案 (是配置的一种)

|              | 配置方式 (常用)                        | 注解方式 (常用)                |
| ------------ | -------------------------------------- | ------------------------------ |
| Bean定义     | <bean class=""/>                       | @Component                     |
| Bean名称     | bean标签的id或name属性                 | @Component的value值            |
| Bean注入     | bean标签的子标签<property..            | @Autowired(1) + @Qualifier (?) |
| Bean生命周期 | bean标签的init- \| destroy- method属性 | @PostConstruct \| @PreDestroy  |
| Bean延迟创建 | bean标签的lazy-init \| scope 属性      | @Lazy \| @Scope                |
| **适用场景** | 第三方源码类的对象创建                 | 自定义类的简单应用对象创建     |

- 注解的优势: 简单, 可读性高 (找到类就相当于找到配置)
- 配置的优势: 解耦, 非侵入性 (代码与配置分开互不干扰)





#### 小结

- 注解和配置是什么关系?
  - 
- 注解和配置能否混搭使用?
  - 



### 09使用注解改造案例【掌握】

#### 目标

- 使用注解改造CRUD案例工程



#### 1. 改造CRUD案例工程

1. 复制工程: spring-day02-ax

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
- 改造后的案例是注解开发还是XML配置开发?
  - 



### 10纯注解开发【了解】

#### 目标

- 找到剩余配置的替代注解
- 掌握纯注解开发的IOC创建方式



#### 1. 剩余配置的替代注解

- 配置文件的替代注解: @Configuration
- 注解扫描配置的替代注解: @ComponentScan
- 加载配置文件的替代注解: @PropertySource
- 导入配置文件的替代注解: @Import
- 第3方对象创建的替代注解: @Bean

1. com.itheima.crud.Config

   ```java
   
   ```



#### 2. 创建纯注解开发的IOC

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

