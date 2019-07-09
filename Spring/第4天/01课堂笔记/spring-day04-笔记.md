### 01复习

#### 目标

- 了解常见的面试题



#### 1. 常见的面试题

##### 1.1 什么是AOP?

- AOP是面向切面编程的简写是一种主流的编程思想
- Spring AOP的底层是动态代理技术
- AOP的主要作用是做非侵入式的业务增强



##### 1.2 jdk和cglib的区别?

|          | JDK                                           | CGLIB                                |
| -------- | --------------------------------------------- | ------------------------------------ |
| 实现方式 | 利用 **实现** 接口方法来拦截目标方法          | 利用 **继承** 覆写方法来拦截目标方法 |
| 实现前提 | 目标对象 **需要实现接口**                     | 需要目标方法未使用final/static修饰   |
| 实现效率 | JDK1.6以前较Cglib慢; 1.6以及1.7大量调用时较慢 | 1.8时被JDK代理超越                   |



##### 1.3 什么是切面?

- 切面是由切入点和通知组成

- 切入点是需要进行增强的方法
- 通知是需要增加的内容和增加时机(前后异常始终)



#### 小结

- 请说出以下指示符的作用?
  - bean: 
  - within:
  - execution: 
- 请说出一下注解的作用?
  - @Aspect: 
  - @Pointcut: 
  - @Before:
  - @AfterReturning:
  - @AfterThrowing:
  - @After: 
- Spring的优点有哪些?
  - IOC解耦、AOP支持.. 等
  - 



### 02事务的概念【了解】

#### 目标

- 了解事务的概念
- 理解事务的特性



#### 1. 事务的概念



#### 2. 事务的特性



#### 小结

- 



### 03Spring声明式事务【了解】

#### 目标

- 理解什么是声明式事务?
- 理解Spring事务相关API



#### 1. 什么是声明式事务



#### 2. Spring事务相关API



#### 小结

- 



### 04事务的隔离级别【理解】

#### 目标

- 理解事务的隔离级别



#### 1. 事务的隔离级别

##### 1.1 ISOLATION_DEFAULT



##### 1.2 ISOLATION_READ_UNCOMMITTED



##### 1.3 ISOLATION_READ_COMMITTED



##### 1.4 ISOLATION_REPEATABLE_READ



##### 1.5 ISOLATION_SERIALIZABLE



#### 小结

- 



### 05事务的传播行为【理解】

#### 目标

- 理解事务的传播行为



#### 1. 事务的传播行为

##### 1.1 REQUIRED



##### 1.2 SUPPORTS



##### 1.3 MANDATORY



##### 1.4 REQUIRES_NEW



##### 1.5 NOT_SUPPORTED



##### 1.6 NEVER



##### 1.7 NESTED





#### 小结

- 



### 06XML案例【掌握】

#### 目标

- 使用XML实现声明式事务管理



#### 1. 实现声明式事务管理

##### 1.1 搭建环境



##### 1.2 业务代码



##### 1.3 事务配置



##### 1.4 单元测试



#### 小结

- 



### 07注解改造案例【掌握】

#### 目标

- 使用注解改造案例



#### 1. 使用注解改造案例

##### 1.1 改造环境



##### 1.2 注解代码



##### 1.3 配置支持



##### 1.4 单元测试



#### 小结

- 



### 08纯注解改造案例【理解】

#### 目标

- 使用注解代替所有配置



#### 1. 使用注解代替所有配置

##### 1.1 配置类

- SpringConfig.java

```java

```

- JdbcConfig.java

```java

```

##### 1.2 单元测试

- AnnoTests.java

```java

```



#### 小结

- 



### 09Spring编程式事务【了解】

#### 目标

- 了解编程式事务概念
- 实现编程式事务案例



#### 1. 编程式事务概念



#### 2.编程式事务案例

##### 2.1 环境改造



##### 2.2 业务改造



##### 2.3 配置支持



##### 2.4 单元测试





#### 小结

- 



### 10两种方式的区别【了解】

#### 目标

- 两种事务管理方式的区别?



#### 1. 两种事务管理方式的区别

##### 1.1 应用场景

- 

##### 1.2 应用市场

- 

##### 1.3 应用难度

- 



#### 小结

- 



### 11总结

- 什么是ACID原则?
  - Atomicity:
  - Consistency: 
  - Isolation: 
  - Durability:
- 以下隔离级别分别解决了什么问题?
  - ISOLATION_READ_UNCOMMITTED:
  - ISOLATION_READ_COMMITTED: 
  - ISOLATION_REPEATABLE_READ:
  - ISOLATION_SERIALIZABLE: 

- 请说出以下传播行为的含义
  - REQUIRED:
  - SUPPORTS:
  - MANDATORY:
  - REQUIRES_NEW:
  - NOT_SUPPORTED:
  - NEVER:
  - NESTED:
- 声明式事务的好处有哪些?
  - 
- 请描述以下注解的作用?
  - @EnableTransactionManagement:
  - @Transactional: 



