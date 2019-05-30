### 01开发常见的依赖问题【了解】

#### 目标

1. **了解依赖问题**: 耦合度过高
2. **解决依赖问题**: 降低耦合度

#### 了解依赖问题

##### 创建项目

- 项目名称: spring-day01-dep

##### 分层建设

- 代码较多划分多个包
- 层次分明: 持久层(dao), 业务层(service), 视图层(controller)

###### com.itheima.dao

- UserDao.java

  ```java
  
  ```

- impl.UserDaoOracleImpl.java

  ```java
  
  ```

- impl.UserDaoMysqlImpl.java

  ```java
  
  ```

- model.User.java

  ```java
  
  ```

  

###### com.itheima.service

- UserService.java

  ```java
  
  ```

- UserServiceImpl.java

  ```java
  
  ```



###### com.itheima.controller

- UserController.java

  ```java
  
  ```



##### 分析问题

###### 代码耦合度过高

- 依赖丢失无法编译: UserDaoMysqlImpl

- 切换实现要改代码: new UserDaoOracleImpl();



#### 解决依赖问题

##### 祸水东引

- 将创建UserDaoMysqlImpl对象的过程交给 BeanFactory 实现

##### 逍遥法外

- 将UserDaoMysqlImpl类的引用放置到虚拟机编译范围之外

##### 【扩展】设计模式

- 以上解决问题的方法极受欢迎, 称之为 **工厂设计模式**
- 作用
  - 创建对象
  - 降低耦合
  - 消除重复
- 工厂设计模式包括: 简单工厂(静态工厂), 工厂方法, 抽象工厂
  - 简单工厂: 创建固定的对象 (根据参数创建对象, 不属于设计模式)
  - 工厂方法: 创建多态的对象 (利用多态,反射创建对象)
  - 抽象工厂: 创建一系列多态的对象 (维护对象依赖关系)



#### 小结

- 发现了什么依赖问题?
  - 
- 创建对象 **代码耦合度过高** 如何解决?
  - 



### 02Spring框架概述

#### 目标

1. 了解Spring框架
2. 了解Spring优点



#### 了解Spring框架

##### Spring介绍

- Spring是 **分层** 的轻量级开源框架
- Spring核心是**IOC**(控制反转) 和 **AOP**(面向切面编程)
- Spring实现了众多优秀框架的整合

##### Spring优点

- IOC解耦
  - 可以将对象间的依赖关系交由spring管理
  - 避免硬编码造成的程序间过渡耦合
- AOP支持
  - 可以使用切面编程思想对方法进行增强
- 声明式事务
  - 可以通过配置或者注解的方式管理事务
  - 不需要硬编码管理事务
- 方便测试
  - 可以通过注解方便的测试Spring程序
- 方便集成
  - 其内部提供了对各种优秀框架的直接支持
- 设计精良
  - Spring的源码设计精妙、结构清晰值得学习

##### Spring结构

![1559212182908](assets/1557482552440.png)

###### Data Access/Integration

- JDBC: 对各大数据库厂商进行抽象处理
- ORM: 集成orm框架支持对象关系映射处理
- OXM: 提供了对 Object/XML映射实现的抽象层
- JMS: 主要包含了一些制造和消费消息的特性
- Transactions: 支持编程和生命性的事务管理



###### Web

- Websocket: 提供了WebSocket和SocketJS的实现
- Servlet: 利用MVC(model-view-controller)的实现分离代码
- Web: 提供了基础的面向 Web 的集成特性(如: 文件上传)
- Portlet: 提供了Portlet环境下的MVC实现



###### 中间层

- AOP: 提供了符合AOP要求的面向切面的编程实现

- Aspects: 提供了与AspectJ的集成功能

- Instrumentation: 提供了类植入（Instrumentation）的支持和类加载器的实现
- Messaging: 用于构建基于消息的应用程序



###### Core Container

- Beans: Bean工厂与bean的装配
- Core: 依赖注入IoC与DI的最基本实现
- Content: IOC容器的企业服务扩展
- SpEl: 用于在运行时查询和操纵对象的表达式

###### Test

- 支持使用 JUnit 和 TestNG 对 Spring 组件进行测试





#### 小结

- 

