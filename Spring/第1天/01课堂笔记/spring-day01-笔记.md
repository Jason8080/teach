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

- 依赖丢失无法编译: UserDaoMysqlImpl
- 切换实现要改代码: new UserDaoOracleImpl();



#### 解决依赖问题







