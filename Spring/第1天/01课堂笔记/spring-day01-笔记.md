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

1. 



#### 小结

- 

