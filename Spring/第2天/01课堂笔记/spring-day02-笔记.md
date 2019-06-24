### 01复习【了解】

#### 目标

- 了解常见的面试题
- 搭建 IOC 案例工程
- 什么是IOC ?
- 什么是AOP ?



#### 1. 了解常见的面试题

##### 1.1 说出对Spring的理解

- Spring是一个分层的轻量级开源框架
- 核心思想是IOC 和 AOP 支持声明式事务
- 是一个整合型框架对很多优秀框架做了整合支持

##### 1.2 什么是IOC

- IOC(Inversion Of Control)是控制反转思想的简写
- 控制反转指的是将创建对象的行为转交给IOC的工厂完成
- IOC的优势包括解耦, 支持单例模式, 支持依赖注入等

##### 1.3 什么是AOP

- AOP(Aspect Oriented Programming)是面向切面编程的简写
- 面向切面编程是一种非侵入性编程的手段
- 是指将业务需求抽象成切面在不改动目标对象的基础上对方法(系统)进行增强



#### 2. 搭建 IOC 案例工程

##### 2.1 工程名称: spring-day02-crud

##### 2.2 添加依赖: pom.xml

```xml
<!-- 1. Spring IOC依赖 -->

<!-- 2. Spring jdbc依赖 -->

<!-- 3. druid连接池依赖 -->

<!-- 4. mysql驱动依赖 -->

<!-- 5. junit单元测试依赖 -->
```

##### 2.3 创建: Account.java

```java

```



##### 2.4 配置: applicationContext.xml

```xml

```



##### 2.5 测试: CrudTests.java

```java

```



#### 总结

- Spring是一个优秀的整合型开源框架
- IOC是自动创建对象并存储对象的容器
- AOP是一种非侵入性的编程思想



### 02实现CRUD操作【理解】

#### 目标

- 使用jdbcTemplate操作数据库
- 实现CRUD操作(create/retrieve/update/delete)



#### 1. 使用jdbcTemplate操作数据

- AccountDaoImpl.java

```java

```

- AccountServiceImpl.java

```java

```

- CrudTests.java

```java

```



#### 2. 使用IOC管理对象生命周期

- db.properties

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



- applicationContext.xml

```xml

```



#### 小结

- jdbcTemplate是通过什么方法注入的?
  - 
- 配置文件中的bean是什么时候创建的?
  - 



### 03基于注解创建对象【掌握】

#### 目标

- 掌握注解@Component的用法
- 理解注解及相关配置的作用



#### 1. 注解@Component的用法

##### 1.1 工程名称: spring-day02-anno

##### 1.2 pom.xml

```xml

```

##### 1.3 Account.java

```java

```

##### 1.4 applicationContext.xml

```xml

```

##### 1.5 单元测试: AnnoTests.java

```java

```



#### 2. 理解注解及相关配置的作用

##### 2.1 注解的作用

- @Component
  - 创建对象并添加到IOC容器
  - 需要配合注解扫描配置使用

##### 2.2 标签的作用

- <context:component-scan base-package="com.itheima.anno"/>
  - 扫描注解位置并解析处理
  - base-package是扫描的包路径 (支持本包和所有子包)



#### 小结

- @Component的用法?
  - 
  - 
- @Component的作用?
  - 



### 04创建对象的注解【掌握】

#### 目标

- 创建对象的延伸注解



#### 1. 创建对象的延伸注解

- 为了在3层架构中识别不同层的对象延伸3个注解
- 使用不同的 创建注解 来区别不同层的对象

- Account.java

```java

```



#### 小结

- 在三层架构中延伸出了哪些创建对象的注解?
  - 
  - 
  - 



### 05依赖注入的注解【掌握】

#### 目标

- 了解依赖注入的前提
- 使用赋值功能的注解



#### 1. 了解依赖注入的前提

- 使用@Component创建对象并加入IOC容器

- 必须创建对象并加入到IOC容器, 否则无法使用IOC容器的注入功能



#### 2 掌握赋值功能的注解

- User.java

```java

```

- 单元测试: testDi

```java

```



#### 小结

- 使用依赖注入的前提是什么?
  - 
- 赋值(依赖注入)的注解有哪几个?
  - 
  - 
  - 



### 06生命周期的注解【了解】

#### 目标

- 了解生命周期的过程
- 了解生命周期的注解



#### 1. 了解生命周期的过程

- 生命周期: 对象的创建到销毁的过程
- 如: 创建时间、作用范围、创建、创建后、销毁前、销毁



#### 2. 了解生命周期的注解

- Account.java

```java

```

- 单元测试: testCycle

```java

```



#### 小结

- 影响对象生命周期的注解有哪些?
  - 
  - 
  - 
  - 



### 07