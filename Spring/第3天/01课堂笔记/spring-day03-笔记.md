### 01复习

#### 目标

- 了解Spring中的设计模式



#### 1. 了解Spring中的设计模式

1. IOC的底层/原理是什么?
   - 
2. IOC中的Bean都是单例的吗?
   - 
3.  JdbcTeamplate用了什么设计模式?
   - 



#### 小结

- Spring中学习了哪些设计模式?
  - 
  - 
  - 
- AOP的底层/原理是什么?
  - 



### 02AOP的概念【理解】

#### 目标

- 理解AOP相关的概念
- 理解AOP相关的术语



#### 1. 相关的概念

##### 1.1 AOP是什么

- 面向切面编程: AOP (Aspect Oriented Programming) 的简写
- 面向切面编程: 是一种代码设计思想

##### 1.2 AOP的作用

- 在不修改目标对象的情况下添加新的业务逻辑 (增强)

![1562124381705](assets/1562124381705-1571725882391.png) 



##### 1.3 AOP的原理

- **底层使用了动态代理技术**实现的AOP切面编程思想

  ```java
  // 代理方法
  public void sing(Integer money){
      if(money > 10000){ // 新增的业务逻辑 (增强)
          targer.method(money); // 调用目标方法
      }
  }
  ```

  



#### 2. 相关的术语

##### 2.1 连接点

- 目标对象中的所有方法

##### 2.2 切入点

- 目标对象中需要增强的方法

##### 2.3 通知

- 目标对象需要增强的内容

##### 2.4 切面

- 切面是切入点与通知的组合





#### 小结

- Spring AOP 的原理是什么?
  - 
- 请描述下列术语的含义:
  - 连接点: 
  - 切入点: 
  - 通知: 
  - 切面: 



### 03AOP的XML案例【掌握】

#### 目标

- 使用AOP自动记录日志
- 掌握AOP动态代理细节



#### 1. AOP自动记录日志

1. 工程名称: spring03_aop_01

2. 添加依赖: pom.xml

    ```xml
    <!-- 1. 添加Spring IOC和AOP依赖 -->
    
    <!-- 2. 添加AspectJ(第三方框架: 支持AOP切入点表达式语法)依赖 -->
    
    <!-- 3. 添加SpringTest依赖 -->
    ```

3. 业务处理: com.itheima.xml.impl.AccountServiceImpl

    ```java
    
    ```
    
4. 记录日志: com.itheima.xml.advice.LogAdvice

    ```java
    
    ```

5. 配置AOP: applicationContext.xml

    ```xml
    
    ```

6. 单元测试: XmlTests

    ```java
    
    ```



#### 2. AOP动态代理细节

##### 2.1 动态代理的类型

1. 打印代理对象字节码: XmlTests

    ```java
    
    ```

2. 实现类实现接口: com.itheima.xml.AccountService

    ```java
    // 1. 再次打印代理对象字节码: 观察代理类型的变化
    ```

##### 2.2 动态代理的配置

- 指定代理类型: applicationContext.xml

    ```xml
<!-- 
    	<aop:config: 配置AOP
    		proxy-target-class: 配置是否强制使用cglib动态代理
    -->
    <aop:config proxy-target-class="true">
    ```



#### 小结

- 自动记录日志的原理是什么?
  - 

- 两种动态代理Spring是如何选择的?
  - 



### 04切入点表达式【理解】

#### 目标

- 理解什么是切入点表达式
- 了解切入点表达式指示符



#### 1. 什么是切入点表达式

- 定位切入点的1种语法规则



#### 2. 切入点表达式指示符

- 切入点表达式常见的 指示符 (PCD)有以下三种

| 指示符        | 示例                                                    | 作用(细粒度)        |
| ------------- | ------------------------------------------------------- | ------------------- |
| bean          | bean(accountService)                                    | 精确到IOC容器的bean |
| within        | within(com.itheima.xml.service.impl.AccountServiceImpl) | 精确到类            |
| **execution** | execution(public void com.itheima..save(..))            | **精确到方法**      |

##### 2.1 bean

1. pointcut.xml

    ```xml
    
    ```

##### 2.2 within

1. pointcut.xml

    ```xml
    
    ```

##### 2.3 execution

1. pointcut.xml

    ```xml
    
    ```

`execution(modififiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?) `

- **modififiers-pattern**: 权限访问修饰符 (可填) 
- **ret-type-pattern**: 返回值类型 (必填) 
- **declaring-type-pattern**: 全限定类名 (可填) 
- **name-pattern**: 方法名 (必填) 
- **param-pattern**: 参数名 (必填) 
- **throws-pattern**: 异常类型 (可填) 



#### 小结

- 什么是切入点表达式?
  - 
- 常用的指示符有什么区别?
  - bean: 
  - within: 
  - execution: 





### 05AOP的通知类型【了解】

#### 目标

- 理解AOP的通知类型
- 理解四种通知的配置



#### 1. AOP的通知类型

- SpringAOP的通知类型有以下4种: 

    ```java
    try{
        [前置通知]
        // 执行目标对象方法..
        targer.method(..);
        [后置通知]
    } catch (Exception e){
        [异常通知]
    } finally {
        [最终通知]
    }
    ```

#### 2. 四种通知的配置

1. 通知类型分类: 前置通知、后置通知、异常通知、最终通知
2. 提供通知方法: com.itheima.xml.advice.LogAdvice

    ```java
    
    ```

3. 配置通知类型: advice.xml

    ```xml
    
    ```



#### 小结

- 通知分为哪几类?
  - 



### 06AOP的环绕通知【掌握】

#### 目标

- 掌握通用通知的使用
- 掌握环绕通知的优点



#### 1. 环绕通知

1. com.itheima.xml.advice.LogAdvice

    ```java

    ```

1. advice.xml

   ```xml
   
   ```

   

#### 小结

- 环绕通知的优点?
  - 



### 07AOP的注解案例【理解】

#### 目标

- 使用AOP相关注解改造XML案例



#### 1. 注解改造XML案例

##### 1.1 改造工程

- 工程名称: spring03_anno_02

##### 1.2 改造通知

- com.itheima.xml.advice.LogAdvice

    ```java

    ```

##### 1.3 改造配置

- advice.xml

    ```xml

    ```



#### 小结

- 请描述以下注解的作用?
  - @Aspect: 
  - @Pointcut: 
  - @Around: 





### 08事务的概念【了解】

#### 目标

- 了解事务的作用
- 理解事务的特性



#### 1. 事务的作用

- 在业务中 **保证数据安全**

![1565246073783](assets/1565246073783.png)  



#### 2. 事务的特性

- 事务的四大特性也叫事务的 **ACID原则**

##### 2.1 原子性（Atomicity）

- 

##### 2.2 一致性（Consistency）

- 

##### 2.3 隔离性（Isolation）

- 

##### 2.4 持久性（Durability）

- 



#### 小结

- 事务的作用是什么?
  - 
- 事务的ACID原则分别是什么?
  - 



### 09Spring声明式事务【了解】

#### 目标

- 理解什么是声明式事务?
- 理解Spring事务相关API



#### 1. 什么是声明式事务

- 通过 **面向切面编程思想** 来实现的事务管理方式
- Spring声明式事务的简写: TX

![1565248277054](assets/1565248277054.png) 

#### 2. Spring事务相关API

##### 2.1 PlatformTransactionManager

- 事务管理接口: 定义了提交事务、获取事务、回滚事务的方法。 

![1562574934801](assets/1562574934801.png) 

##### 2.2 TransactionStatus

- 事务状态接口: 定义了Spring内部的事务状态规范

![1562575940075](assets/1562575940075.png) 

- 存储点: 用于设置事务回滚的位置

```java
// 创建存储点
Object savepoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
// 执行数据库操作
userService.save();
// 回滚到存储点
TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savepoint);
```

![1566116589347](assets/1566116589347.png) 



##### 2.3 TransactionDefinition

- 事务信息接口: 定义了事务的隔离级别、传播行为、超时时间、是否只读等。

![1562575584950](assets/1562575584950.png) 

#### 小结

- 什么是声明式事务?
  - 
- 事务管理接口中有哪些方法?
  - 



### 10事务的隔离级别【理解】

#### 目标

- 理解事务的隔离级别



#### 1. 事务的隔离级别

- 事务的隔离级别表示的是: 多个事务之间的影响程度

![1565251783277](assets/1565251783277.png) 

##### 1.1 ISOLATION_DEFAULT

- 

##### 1.2 ISOLATION_READ_UNCOMMITTED

- 

| 时间 | 事务A                                                     | 事务B                                                        |
| ---- | --------------------------------------------------------- | ------------------------------------------------------------ |
| 1    | 开启事务                                                  |                                                              |
| 2    |                                                           | 开启事务                                                     |
| 3    | // 原来是小明<br/>update user set name="小白" where id=1; |                                                              |
| 5    |                                                           | <font color='red'>// 结果是小白</font><br/>select name from user where id=1; |
| 6    | 回滚事务                                                  |                                                              |

##### 1.3 ISOLATION_READ_COMMITTED

- 

| 时间 | 事务A                                                     | 事务B                                                        |
| ---- | --------------------------------------------------------- | ------------------------------------------------------------ |
| 1    | 开启事务                                                  |                                                              |
| 2    |                                                           | 开启事务                                                     |
| 3    |                                                           | // 结果是小明<br/>select name from user where id=1;          |
| 5    | // 原来是小明<br/>update user set name="小白" where id=1; |                                                              |
| 6    | 提交事务                                                  |                                                              |
| 7    |                                                           | <font color='red'>// 结果不一样</font><br/>select name from user where id=1; |

##### 1.4 ISOLATION_REPEATABLE_READ

- 

| 时间 | 事务A                                                        | 事务B                                               |
| ---- | ------------------------------------------------------------ | --------------------------------------------------- |
| 1    |                                                              | 开启事务                                            |
| 2    | 开启事务                                                     |                                                     |
| 3    | // 结果是小明<br/>select name from user where id=1;          | // 结果是小明<br/>select name from user where id=1; |
| 5    | <font color='red'>// 不能修改</font><br/>update user set name="小白" where id=1; | // 结果是一样<br/>select name from user where id=1; |
| 6    |                                                              | 提交事务                                            |
| 7    | // 可以修改<br/>update user set name="小白" where id=1;      |                                                     |

##### 1.5 ISOLATION_SERIALIZABLE

- 

| 时间 | 事务A    | 事务B                                                   |
| ---- | -------- | ------------------------------------------------------- |
| 1    |          | 开启事务                                                |
| 2    |          | // 结果是小明<br/>select name from user where id=1;     |
| 3    |          | // 可以修改<br/>update user set name="小白" where id=1; |
| 5    |          | 提交事务                                                |
| 6    | 开启事务 |                                                         |



#### 小结

- 什么是脏读?

  - 
- 什么是幻读?
  - 



### 11事务的传播行为【理解】

#### 目标

- 理解事务的传播行为



#### 1. 事务的传播行为

- 当前方法对事务的要求

![1562831970253](assets/1562831970253.png) 

##### 1.1 REQUIRED

- 需要: 

##### 1.2 SUPPORTS

- 支持: 

##### 1.3 MANDATORY

- **强制**: 

##### 1.4 REQUIRES_NEW

- 新:

##### 1.5 NOT_SUPPORTED

- 不支持: 

##### 1.6 NEVER

- **决不**: 

##### 1.7 NESTED

- <font color='red'>嵌套</font>:  



#### 小结

- SUPPORTS与NOT_SUPPORTS的区别?
  - SUPPORTS:
  - NOT_SUPPORTS: 
- 哪些传播行为不满足要求会抛出异常?
  - MANDATORY: 
  - NEVER:



### 12TX - XML案例【掌握】

#### 目标

- 使用XML实现声明式事务管理



#### 1. 实现声明式事务管理

##### 1.1 搭建环境

1. 工程名称: spring03_xml_03

2. 添加依赖: pom.xml

   ```xml
   <!-- Spring IOC 依赖 -->
   
   <!-- aspectJ 切面编程 依赖 -->
   
   <!-- Spring 事务 依赖 -->
   
   <!-- Spring  Jdbc 依赖 -->
   
   <!-- Druid 连接池 依赖 -->
   
   <!-- Mysql 依赖 -->
   
   <!-- Spring 测试 依赖 -->
   
   <!-- Junit 单元测试 依赖 -->
   ```

##### 1.2 业务代码

1. 实体类: com.itheima.xml.domain.Account

   ```java
   
   ```

2. 持久类: com.itheima.xml.dao.impl.AccountDaoImpl

   ```java
   
   ```

3. 业务类: com.itheima.xml.service.impl.AccountServiceImpl

   ```java
   
   ```



##### 1.3 事务配置

1. 添加配置文件: db.properties

   ```properties
   db.driver=com.mysql.jdbc.Driver
   # 针对Mysql 8.x数据库的参数
   #   serverTimezone: 指定时区(UTC)
   #   useSSL: 指定是否使用加密安全连接(false)
   #   allowPublicKeyRetrieval: 是否允许检索公钥(true)
   db.url=jdbc:mysql:///mybatisdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8
   db.username=root
   db.password=root
   ```

2. 配置事务管理: applicationContext.xml

   ```xml
   <!-- 1. 加载数据库参数配置文件 -->
   
   <!-- 2. 编写Spring组件扫描配置 -->
   
   <!-- 3. 创建数据源(连接池对象) -->
   
   <!-- 4. 创建数据库操作模板(JdbcTemplate) -->
   
   <!-- 5. 创建持久层,业务层对象 -->
   
   <!-- 6. 配置事务管理器 -->
   
   <!-- 7. 配置AOP(创建代理对象) -->
   
   <!-- 8. 配置事务管理规则(通知) -->
   ```



##### 1.4 单元测试

1. 单元测试: XmlTests.java

   ```java
   
   ```



#### 小结

- 声明式事务有什么好处?
  - 



### 13TX - 注解案例【掌握】

#### 目标

- 使用注解改造案例



#### 1. 使用注解改造案例

1. 工程名称: spring03_anno_04

2. 使用注解: com.itheima.xml.service.impl.AccountServiceImpl

   ```java
   
   ```

3. 添加配置: applicationContext.xml

   ```xml
   
   ```

4. 单元测试: XmlTests.java

   ```java
   
   ```



#### 小结

- @Transactional注解的作用是什么?
  - 



### 14TX - 纯注解案例【理解】

#### 目标

- 使用注解代替所有配置



#### 1. 使用注解代替所有配置

1. 创建配置类: com.itheima.xml.config.SpringConfig

   ```java
   
   ```

2. 创建数据库配置类: com.itheima.xml.config.JdbcConfig

   ```java
   
   ```

3. 单元测试: AnnoTests

   ```java
   
   ```



#### 小结

- @EnableTransactionManagement注解的作用?
  - 



### 15Spring编程式事务【了解】

#### 目标

- 了解编程式事务概念
- 实现编程式事务案例



#### 1. 编程式事务概念

- 通过 **编码** 来实现的事务管理方式
- 以下是Spring封装的API

##### 1.1 TransactionTemplate

- 

##### 1.2 TransactionCallback

- 





#### 2.编程式事务案例

##### 2.1 环境改造

1. 工程名称: spring03_code_05

##### 2.2 业务改造

1. 事务编码: com.itheima.xml.service.impl.AccountServiceImpl

   ```java
   
   ```



##### 2.3 配置支持

1. 添加配置: applicationContext.xml

   ```xml
   <!-- 配置事务管理模板对象 -->
   
   ```



##### 2.4 单元测试

1. 单元测试: XmlTests

   ```java
   
   ```



#### 小结

- 编程式事务有什么好处?
  - 





### 16总结

1. 什么是代理模式?

   - 

2. 动态代理JDK和CGLIB的区别?

   - 
   - 

3. Spring AOP的底层是什么?

   - 

   - 

4. 切面和切入点以及通知是什么?

   - 
   - 

5. 通知类型有哪些?

   - 

   - 

   - 

   - 

   - 

6. AOP相关的注解有哪些?

   - 

   - 

   - 

   - 

   - 

7. 事务的作用是什么?

   - 

8. 什么是ACID原则?

   - Atomicity:

   - Consistency: 

   - Isolation: 

   - Durability:

9. 以下隔离级别分别解决了什么问题?

   - ISOLATION_READ_UNCOMMITTED:

   - ISOLATION_READ_COMMITTED: 

   - ISOLATION_REPEATABLE_READ:

   - ISOLATION_SERIALIZABLE: 

10. 请说出以下传播行为的含义:

    - REQUIRED:

    - SUPPORTS:

    - MANDATORY:

    - REQUIRES_NEW:

    - NOT_SUPPORTED:

    - NEVER:

    - NESTED:

11. 声明式事务的好处是什么?

    - 

12. 请描述以下注解的作用?

    - @EnableTransactionManagement:

    - @Transactional: 

13. Spring的优点有哪些?

    - 
    - 
    - 