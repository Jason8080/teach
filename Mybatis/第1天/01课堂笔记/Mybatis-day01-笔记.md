#### 01课程介绍与准备【准备】

##### 目标

- 了解课程安排
- 准备开发环境

##### 步骤

###### 学习记录分类

1. 课堂笔记
2. 课前资料
3. 视频
4. 代码
5. 预习资料
6. 答疑

###### 阶段学习计划

1. mybatis框架
2. spring框架
3. springmvc框架

###### 开发环境准备

-  jdk8+
-  maven3+
-  idea2017+
-  mysql5+
-  **执行sql语句准备数据**



##### 小结

1. 课后学习记录有哪些?

   

2. 将要学习哪些框架

   



#### 02学习Mybatis框架【了解】

##### 目标

- 了解什么是 **框架 ** ?
- 了解什么是 **Mybatis框架** ?

##### 步骤

###### 在生活中寻找框架的例子

- 生活中的 **水杯模具** 相当于开发中的 **框架**



###### 总结框架例子有什么特点

- 



###### 简洁的说明什么是框架

- 



###### 开发中的代码分层是什么

- J2EE项目中经过不断演化后, 现分层为表现层，业务层，持久层。
  - 表现层常见框架 - SpringMvc

  - 业务层常见框架 - Spring

  - 持久层常见框架 - Mybatis

  

###### 了解Mybatis框架的特点

- [官网](http://www.mybatis.org/mybatis-3/)
  - 
- 历史
  - 
- 特点
  - 



##### 小结

1. 框架有哪些特点呢?

   - 

2. Mybatis有哪些特点呢?

   - 




#### 03为什么不直接使用jdbc【理解】

##### 目标

- 使用jdbc做需求案例
- 总结案例存在的问题

##### 步骤

- ==根据ID查找用户==

1. 创建Maven项目 (已准备)
2. 创建jdbc模块 (已准备)
3. 创建测试类 (已准备)
4. **引入依赖**
5. **开发步骤**
6. **测试**



##### 操作

###### 引入依赖

```xml

```

###### 开发步骤

```java

```


###### 测试

```java

```

##### 小结


- jdbc存在哪些问题?
  - 




- 为什么不直接使用jdbc?

  - 



#### 04快速入门Mybatis【掌握】

##### 目标

- 使用Mybatis做需求案例

##### 步骤

- ==查找所有用户==

1. idea: 创建模块 (已准备)
2. pom.xml: **导入框架jar包** 
3. resources: **导入xml文件** ([官网](http://www.mybatis.org/mybatis-3/))
4. package: 创建java类
5. main: **测试** (官网)



##### 操作

###### 导入框架jar包

```xml

```

###### 创建xml文件

1. 数据库文件

   ```xml
   
   ```

2. sql文件

   ```xml
   
   ```



###### 创建java类

1. User.java

   ```java
   
   ```

2. UserMapper.java

   ```java
   
   ```

   

###### 开发步骤

1. 创建连接
2. 执行操作
3. 关闭资源

###### 测试

```java

```



##### 小结

- 启用Mybatis框架需要哪些配置?
  - 
- 为什么需要操作类?
  - 给sql语句分类
  - 调用操作类方法执行操作, 避免直接使用jdbc



#### 05自造框架 - 架构设计【了解】

##### 目标

- 了解Myabtis框架为什么设计成这样?
- 如果我们来设计Mybatis应该如何设计?

##### 步骤

###### 希望框架解决什么问题

- jdbc频繁开关连接资源很浪费
- 结果集处理麻烦代码重复率高
- sql语句硬编码在java代码中
- 连接参数硬编码在java代码中



###### 怎么解决问题

- 用连接池技术提升连接资源使用率
- 封装结果集成为对象返回
- 分开存放sql语句
- 分开存放连接参数



###### 用什么技术解决

![1554365261338](assets/1554365261338.png) 



###### 技术选型

- JDBC ---- 连接数据库
- C3P0 ---- 连接池技术提升资源使用率
- 反射技术 ---- 封装结果集返回对象
- Dom4J ---- 解析配置文件
- 动态代理技术 ---- 根据配置信息生成实例对象
- 泛型技术 ---- 指定返回的对象类型
- Junit ---- 单元测试



##### 小结

- Mybatis为什么需要xml配置文件 ?
  - 
- Mybatis为什么不需要实现类?

  - 



#### 06自造框架 - 环境准备【理解】

##### 目标

- 将框架创建成Maven项目
- 引入需要依赖的jar包

##### 步骤

- ==查找所有用户== *与Myabtis入门案例的需求一致*

1. idea: 创建Maven模块 (已准备)
2. pom.xml: **引入使用到的工具jar包**
3. **引入文件**

##### 操作

###### 引入依赖

```xml

```

###### 引入文件

- ==引入案例 **所有文件**== , 唯独不引入Mybatis.

1. User.java (已复制)
2. UserMapper.java (已复制)

3. mybatis.xml (已复制)
4. userMapper.xml(已复制)



##### 小结

1. 需要准备哪些java类?

   

2. 需要准备哪些配置?

   



#### 07自造框架 - 代码设计【理解】 

##### 目的

- 编写核心的工具类

##### 步骤

###### 封装配置文件

1. Configuration.java - **mybatis.xml**
2. Mapper.java - **userMapper.xml**
3. SqlSession.java - 提供生成实例对象的方法

###### 加载配置文件

1. **mybatis.xml**
2. **userMapper.xml**

###### 创建执行工具

1. public static <T> List<T> selectList(Connection con, Mapper mapper);
2. private static List handler(rs, resultType)

##### 操作

###### 核心代码封装

1. Configuration.java封装主配置文件

```java

```

2. Mapper.java封装操作映射配置文件

```java

```

2. SqlSession.java提供映射器的动态代理

```java

```

###### 核心配置加载

```java

```

###### 创建数据库源

```java

```

###### 创建执行工具

```java

```

##### 小结

- 存储文件内容的java类有哪些?

  

- 反射时应注意什么?

  

  

#### 08自造框架 - 加载主配置文件【理解】

##### 目标

- 巩固dom4j
- 学习mybatis.xml文件的封装

##### 步骤

###### 解析

##### 操作

###### 解析

```java

```

##### 小结

- 查询指定名称的节点语法是怎样的?

  

- Configuration.java中封装了哪些内容?

 

  

#### 09自造框架 - 加载映射文件【理解】

##### 目标

- 巩固dom4j
- 学习mapper.xml文件的封装

##### 步骤

###### 解析

##### 操作

###### 解析

```java

```

##### 小结

1. 获取所有元素的语法是怎样的?

    

2. Mapper.java中封装了哪些内容?

   - 

   

#### 10自造框架 - 动态代理【理解】

##### 目标

- 实现sql对象的动态代理对象的创建
- 实现代理对象方法调用的处理器

##### 步骤

###### 解析API

###### API调用

###### 方法处理器

###### 操作实现



##### 操作

###### 解析API

```scheme
public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
                               throws IllegalArgumentException
返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。

参数：
loader - 定义代理类的类加载器
interfaces - 代理类要实现的接口列表
h - 指派方法调用的调用处理程序
返回：
一个带有代理类的指定调用处理程序的代理实例，它由指定的类加载器定义，并实现指定的接口
抛出：
IllegalArgumentException - 如果违反传递到 getProxyClass 的参数上的任何限制
NullPointerException - 如果 interfaces 数组参数或其任何元素为 null，或如果调用处理程序 h 为 null
```

###### API调用

```java

```

###### 方法处理器

```java

```

###### 操作实现

- 开发步骤

 

- 代码示例

```java

```
- 数据源创建

```

```

##### 小结

- 代理对象方法调用时我们在处理器中做了哪些事情?

  1. 

  



#### 12自造框架 - 框架测试【理解】

##### 目标

- 验证自定义的Mybatis的功能

##### 步骤

###### 测试

- ==开发步骤与Mybatis入门案例一致==

1. 创建连接
2. 执行操作
3. 关闭资源

###### 结果

##### 操作

###### 测试

```java

```

###### 结果

```html
Disconnected from the target VM, address: '127.0.0.1:59494', transport: 'socket'
User{id=1, username='王五', birthday=null, sex='2', address='null'}
User{id=10, username='张三', birthday=2014-07-10, sex='1', address='北京市'}
User{id=16, username='张小明', birthday=null, sex='1', address='河南郑州'}
User{id=22, username='陈小明', birthday=null, sex='1', address='河南郑州'}
User{id=24, username='张三丰', birthday=null, sex='1', address='河南郑州'}
User{id=25, username='陈小明', birthday=null, sex='1', address='河南郑州'}
User{id=26, username='王五', birthday=null, sex='null', address='null'}
```





##### 小结

- 自定义框架中如何找到具体的执行语句?

  

- 自定义框架与Myabtis框架有哪些相似?



#### 12总结【了解】

##### 目的

- 总结今天学习的内容

##### 步骤

###### 回顾什么是框架?

- 框架是可重用的代码设计, 简单易用.

###### 回顾jdbc有哪些问题?

- 代码重复
- 浪费资源
- 手动设置参数
- sql硬编码在java代码中

###### 回顾自定义框架的思路?

1. 整理遇到的问题(想解决的问题)
2. 架构设计(怎么解决)
3. 技术分析

###### 回顾Mybatis有哪些特点?

- 开源的
- 基于jdbc封装的
- 简单易用的
- 持久层的

##### 小结

- 今天的重点内容在哪里?

  - 重点是入门案例



