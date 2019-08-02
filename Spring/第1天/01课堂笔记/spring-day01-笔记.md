### 01开发的分层架构【理解】

#### 目标

- 理解开发中的 **三层架构**
- 理解分层架构的作用



#### 1. 理解三层架构

##### 1.1 分层概念

- 三层架构(3-tier architecture): **视图层**, **业务层**, **持久层**

![1559290090936](assets/1559290090936.png)

##### 1.2 分层案例

- 创建项目: spring-day01-tier

###### com.itheima.dao

- com.itheima.tier.dao.UserDao

  ```java
  
  ```

- com.itheima.tier.dao.impl.UserDaoImpl

  ```java
  
  ```

  

###### com.itheima.service

- com.itheima.tier.service.UserService

  ```java
  
  ```

- com.itheima.tier.service.impl.UserServiceImp

  ```java
  
  ```



###### com.itheima.controller

- com.itheima.tier.controller.UserController

  ```java
  
  ```





#### 2. 分层架构的作用

- 项目结构清晰 (提高代码可读性)

  |-- tier

  |---- **controller** // 处理页面信息

  |---- **service** // 处理业务逻辑

  |---- **dao** // 处理数据

- 便于团队协同开发 (提高开发效率)

  > ​	职责分明后, 三个层的代码可以同步进行开发



#### 小结

- 三层架构分为哪三层?
  - 
  - 
  - 
- 为什么要分层架构呢?
  - 
  - 



### 02常见的依赖问题【了解】

#### 目标

- **了解依赖问题**



#### 1. 了解依赖问题

- 代码耦合度过高



##### 1.1 实现类丢失

- 如果编译时丢失UserDaoImpl.java文件将无法编译

![1564640574099](assets/1564640574099.png) 

##### 1.2 切换实现类

- 希望使用Oracle的实现类, 要改动代码重新编译

- com.itheima.tier.dao.impl.UserDaoOracleImpl

```java
package com.itheima.tier.dao.impl;

import com.itheima.tier.dao.UserDao;

/**
 * Oracle用户数据库操作实现类.
 *
 * @author : Jason.lee
 */
public class UserDaoOracleImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("保存Oracle用户成功");
    }
}
```

#### 小结

- 分层架构有哪些依赖问题?
  - 
  - 



### 03解决高耦合问题【理解】

#### 目标

- 解决实现类丢失问题
- 解决实现类切换问题



#### 1. 解决实现类丢失

- 【祸水东引】将创建实现类对象的过程交给 BeanFactory 实现
- com.itheima.tier.BeanFactory

```java
package com.itheima.tier;

import com.itheima.tier.dao.UserDao;
import com.itheima.tier.dao.impl.UserDaoImpl;

/**
 * 创建持久层接口实现类.
 */
public class BeanFactory {
    /**
     * 祸水东引.
     * 将创建实现类对象的过程放置到BeanFactory.
     */
    public static UserDao create(){
        return new UserDaoImpl();
    }
}
```

- 【彻底解决】实现类丢失问题

> ​	学习Class.forName("com.mysql.jdbc.Driver")运行时再加载字节码文件

```java

```



#### 2. 解决实现类切换

- 希望切换实现类时不用改动Java代码

1. beans.properties

```properties
# 用户持久层实现类
UserDao=com.itheima.tier.dao.impl.UserDaoImpl
# 用户服务层实现类
UserService=com.itheima.tier.service.impl.UserServiceImpl
```

2. com.itheima.tier.BeanFactory

```java

```



##### 2.3【扩展】设计模式

- 以上解决代码耦合度过高的方案应用广泛, 称之为 **工厂设计模式**
- 工厂设计模式的作用: 
  - 创建对象
  - 降低耦合
  - 消除重复



#### 小结

- 分层架构有什么依赖问题?
  - 
- 创建对象 **代码耦合度过高** 如何解决?
  - 



### 04分层的其他问题【了解】

#### 目标

- 了解分层架构的其他问题



#### 1. 依赖关系问题

![1564713528158](assets/1564713528158.png) 



#### 2. 创建顺序问题

![1564716026508](assets/1564716026508.png) 

#### 3. 对象个数问题

- 每次请求都创建新的对象 (消耗内存)

```java
public static Object create(String name){
    // clazz = com.itheima.tier.dao.impl.UserDaoImpl
    String clazz = prop.getProperty(name);
    try {
        Class<?> aClass = Class.forName(clazz);
        // 每次访问都创建新的对象
        return aClass.newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
```



#### 小结

- 分层架构还有哪些问题?
  - 
  - 
  - 



### 05Spring框架概述【了解】

#### 目标

- 了解Spring框架
- 了解Spring结构
- 了解Spring优点



#### 1. Spring框架

##### 1.1 官网

- 官网: https://spring.io/

- 官网文档地址: https://spring.io/projects/spring-framework#learn

- 依赖下载地址: https://repo.spring.io/libs-release-local/org/springframework/spring/



##### 1.2 介绍

- Spring是 **分层** 的轻量级开源框架 (重点)
- Spring核心是**IOC**(控制反转) 和 **AOP**(面向切面编程)
- Spring提供了对各种优秀框架的支持和 **整合**



#### 2. Spring结构

- Spring框架采用分层架构，根据不同的功能被划分成了多个模块

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



#### 3. Spring优点

##### 3.1 IOC解耦

- 可以将对象间的依赖关系交由spring管理
- 避免硬编码造成的程序间过渡耦合

##### 3.2 支持AOP

- 可以使用切面编程思想对方法进行增强

##### 3.3 支持声明式事务

- 可以通过配置或者注解的方式管理事务
- 不需要硬编码管理事务

##### 3.4 方便测试

- 可以通过注解方便的测试Spring程序

##### 3.5 方便集成

- 其内部提供了对各种优秀框架的直接支持

##### 3.6 使用简单

- Spring对很多难用的API做了简单的封装

##### 2.7 设计精良

- Spring的源码设计精妙、结构清晰值得学习



#### 小结

- Spring是什么?

  - 

  

- 至少说出3个Spring的优点
  - 
  - 
  - 



### 06IOC容器概念【理解】

#### 目标

- 理解IOC是什么
- IOC有哪些作用



#### 1. IOC是什么

- IOC(Inversion Of Control): 将对象的创建(控制)转交给第三方(工厂)完成, 也叫 **控制反转**

![1564726290419](assets/1564726290419.png) 

#### 2. IOC的作用

- **解耦**: 利用IOC的工厂模式解耦创建对象的过程
  - 解决代码耦合度过高问题
- **存储对象**: 可以将创建好的对象 **存储** 起来重复使用 
  - 解决对象个数问题
- **管理依赖关系**: 可以将依赖对象注入需要的对象当中
  - 解决依赖关系问题
- **管理对象创建顺序**: 可以根据依赖关系先后创建对象
  - 解决创建顺序问题



#### 小结

- IOC是什么?
  - 
- IOC有什么作用?
  - 



### 07IOC入门案例【掌握】

#### 目标

- 了解IOC容器的依赖的jar包

- 掌握创建对象的Bean标签
- 掌握创建IOC容器的代码



#### 1. IOC容器依赖的jar包

- 工程名称: spring-day01-ioc
- 添加依赖: pom.xml

```xml

```



#### 2. IOC容器的Bean标签

- com.itheima.ioc.User

```java

```

- 定义对象: beans.xml

```xml

```



#### 3. IOC容器的创建案例

- IocTests

```java

```





#### 小结

- 使用IOC容器需要添加哪些依赖?
  - 

- 在配置文件中使用什么标签定义对象?
  - 

- 如何创建IOC容器?
  - 



### 08创建Bean的细节【了解】

#### 目标

- 了解bean的各个属性
- 了解bean的作用范围
- 了解创建对象的时间
- 了解初始化方法
- 了解销毁方法



#### 1. bean标签的属性

| 属性           | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| id             | 对象的引用名称;一定要唯一； 一次只能定义一个引用名称         |
| name           | 对象的引用名称; 与id区别是：name一次可以定义多个引用名称。   |
| class          | 类的全限定名称                                               |
| scope          | 设置bean的作用范围, 取值：<br/>singleton：单例, 默认值; <br/>prototype：多例 <br/>request：web项目中，将对象存入request域中【了解】<br/>session：web项目中，将对象存入session域中【了解】<br/>globalsession：web项目中，将对象应用于集群环境，没有集群，相当于session【了解】 |
| init-method    | 指定类中初始化方法的名称，在构造方法执行完毕后立即执行【了解】 |
| destroy-method | 指定类中销毁方法名称，在销毁spring容器前执行【了解】         |
| lazy-init      | 设置为true表示在第一次使用对象的时候才创建，只对单例对象有效。 |

#### 2. 对象的作用范围

- 工程名称: spring-day01-xml
- 添加依赖: pom.xml

```xml
<!-- 1.Spring IOC依赖 -->

<!-- 2.Junit 依赖 -->
```

- com.itheima.xml.User

```java

```

##### 2.1 单例

- singleton: **单例**, 只创建一个对象 (启动时创建)
  - lazy-init: **延迟创建**: 第一次使用时创建对象

```xml

```

- XmlTests

```java

```



##### 2.2 多例

-  prototype: **多例**, 每次使用都创建一个新的对象 (使用时创建)

```xml

```



#### 3. 初始化与销毁对象

- init-method: 在构造方法执行后执行的方法
- destroy-method: 容器销毁前执行的方法

```xml

```

- com.itheima.xml.User

```java

```



#### 小结

- 至少说出3个bean标签的属性?
  - 
  
  - 
  - 
  
- 单例和多例的区别 ?
  
  - 
  - 



### 09创建IOC的方式【理解】

#### 目标

- 了解创建IOC常用的3种方式



#### 1. 了解创建IOC常用的3种方式

- IOC容器接口结构图

![1560327236910](assets/1560327236910.png) 

##### 1.1 资源文件创建方式

```java
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
```



##### 1.2 系统文件创建方式

```java
FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("E:\\课堂\\Spring\\第1天\\04代码\\spring1\\spring-day01-ioc\\src\\main\\resources\\beans.xml");
```



##### 1.3 注解配置创建方式

```java
@Test
public void testAnnotation() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
}

@Configuration
static class Config{

    @Bean("user")
    public User createUser(){
        return new User();
    }
}
```



##### 1.4 ~~BeanFactory~~创建方式

```java
Resource resource = new ClassPathResource("beans.xml");
XmlBeanFactory context = new XmlBeanFactory(resource);
```

- 【了解】BeanFactory与ApplicationContext的区别?
  - BeanFactory是Spring容器的顶层接口, 采用 **延迟创建** 对象的思想 
  - ApplicationContext是BeanFactory的子接口, 采用 **即时创建** 对象的思想 



#### 小结

- 创建IOC容器的常用方式有哪几种?

  - 
  - 

  - 



### 10创建对象的方式【理解】

#### 目标

- 构造方法创建 (默认)
- 静态方法创建
- 实例方法创建



#### 1. 构造方法创建

```xml
<!-- 调用构造方法创建对象 -->
<bean id="user" class="com.itheima.ioc.User"/>
```

#### 2. 静态方法创建

- 静态方法

  ```java
  package com.itheima.ioc;
  
  /**
   * 提供静态方法
   * @author : Jason.lee
   */
  public class UserFactory {
      /**
       * 静态方法创建对象.
       */
      public static User create(){
          System.out.println("静态方法执行了===");
          return new User();
      }
      
      /**
       * 动态方法创建对象.
       */
      public User get(){
          System.out.println("动态方法执行了===");
          return new User();
      }
  }
  ```

```java
<!-- 调用静态方法创建对象 -->
<bean id="user6" class="com.itheima.ioc.UserFactory" factory-method="create"/>
```



#### 3. 实例方法创建

```xml
<!-- 调用动态方法创建对象 -->
<bean id="userFactory" class="com.itheima.ioc.UserFactory"/>
<bean id="user7" factory-bean="userFactory" factory-method="get"/>
```



#### 小结

- 创建对象的方式有哪几种?
  - 
  - 
  - 





### 11依赖注入 - 概念【掌握】

#### 目标

- 理解什么是依赖注入



#### 1. 什么是依赖注入

- 如何在IOC创建对象后给对象赋值?
- IOC提供了这种赋值功能: 依赖注入( **DI** : Dependency Injection)

![1560332836105](assets/1560332836105.png) 

#### 小结

- 什么是依赖注入 ( **DI** )?
  - 



### 12DI - 注入方式【理解】

#### 目标

- 掌握依赖注入的两种方式



#### 1. 构造方法赋值

- 创建新类: Person.java

```java

```

- 配置beans.xml

```xml
<!--
    使用constructor-arg标签利用构造方法赋值
    value: 值
    type: 值类型 (与构造方法完全一致)
    name: 属性名称
    index: 构造方法参数位下标(可一起使用,但不建议)
 -->
<bean id="person" class="com.itheima.ioc.Person">
    <constructor-arg type="java.lang.String" index="1" name="name" value="Jason"/>
    <constructor-arg index="0" value="1"/>
</bean>
```

#### 2. set方法赋值(常用)

```xml
<!--
    使用property标签利用set方法赋值
    name: 属性名称
    value: 值
-->
<bean id="person2" class="com.itheima.ioc.Person">
    <property name="id" value="1"/>
    <property name="name" value="Jason"/>
</bean>
```

#### 3. C标签代替构造方法

- 引入C名称空间

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       <!-- c标签命名空间 -->
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
```

- 使用方式

```xml
<!--
    使用c标签利用构造方法赋值
    c:id: 属性名称赋值
    c:_1: 构造方法参数位下标赋值
-->
<bean id="person3" class="com.itheima.ioc.Person" c:id="1" c:_1="Jason"/>
```

#### 4. P标签代替set方法

- 引入P名称空间

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:c="http://www.springframework.org/schema/c"
       <!-- p标签命名空间 -->
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
```

- 使用方式

```xml
<!--
    使用c标签利用构造方法赋值
    p:name: 属性名称赋值
-->
<bean id="person4" class="com.itheima.ioc.Person" p:name="Jason" p:id="1"/>
```



#### 小结

- 依赖注入有哪几种方式?
  - 
  - 



### 13DI - 注入对象【理解】

#### 目标

- 掌握注入bean的方式



#### 1. 注入对象属性

- 配置需要注入的对象

```xml
<!-- 利用构造方法赋值: new String("Jason") -->
<bean id="str" class="java.lang.String">
    <constructor-arg value="Jason"/>
</bean>
```

- 注入bean对象属性值

```xml
<!--
    使用ref对象引用标签注入对象属性值
    	ref: 表示注入的属性是个已存在的bean对象
 -->
<bean id="person5" class="com.itheima.ioc.Person">
    <property name="id" value="1"/>
    <property name="name" ref="str"/>
</bean>
```



#### 小结

- ref标签属性的作用是什么?
  - 



### 14DI - 注入集合【理解】

#### 目标

- 理解注入集合的方式



#### 1. 注入集合属性

- 创建Employee.java

```java

```

- 注入集合属性值

```xml
<!--
    给对象赋值集合属性的值
    property: 使用set方法赋值
        name: 赋值属性名
           array: 数组类型
            list: 有序集合
            set: 无序集合
            map: 双列集合
            properties: 键值对属性
-->
<bean id="employee" class="com.itheima.ioc.Employee">
    <property name="array">
        <array>
            <value>666</value>
            <value>777</value>
        </array>
    </property>
    <property name="list">
        <list>
            <value>666</value>
            <value>777</value>
        </list>
    </property>
    <property name="set">
        <set>
            <ref bean="str"/>
        </set>
    </property>
    <property name="map">
        <map>
            <entry key="name" value-ref="str"/>
            <entry key="id" value="1"/>
        </map>
    </property>
    <property name="properties">
        <props>
            <prop key="name">Jason</prop>
            <prop key="id">1</prop>
        </props>
    </property>
</bean>
```



#### 小结

- 注入了那些集合属性?
  - 





### 15总结

- Spring是什么?
  - 
- 什么是IOC ?
  - 
- 如何创建IOC容器 ?
  - 
  - 
  - 
- 创建对象有哪几种方式?
  - 
  - 
- IOC通过什么功能做到依赖关系管理?
  - 
- 什么是DI ?
  - 

