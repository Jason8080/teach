#### 01复习Mybatis第2天的内容【了解】

##### 目标

- 回顾Mybatis的常用功能为今天的高级功能打下基础

##### 步骤

###### 面试题

- \#{}与${}的区别是什么 ?

  - **\#{}**是Mybatis框架在映射文件中取值的 **占位符**
  - **${}**是Mybatis框架在映射文件中取值的 **拼接符**

  

  - **\#{}**获取的值参与预编译效验特殊字符具**有防SQL注入的作用**
  - **${}**获取的值直接拼接在执行语句中**有SQL注入的风险**

  

  - **\#{}**可以填写 **#{*}** 任何名称获取基本数据类型的参数
  - **\${}**只能填写 **${value}** 来获取基本数据类型的参数

- Mybatis映射文件中如何返回自增长主键值 ?

  - **不支持自增长的数据库** 可以使用 **SelectKey** 标签在 **Insert语句执行后** 执行查询最后主键值的语句并反射到参数对象中的某一个属性

    ```xml
    <selectKey resultType="int" keyColumn="id" keyProperty="id" order="AFTER">
        -- 查询当前连接中最后一个自增长主键值
        select LAST_INSERT_ID()
    </selectKey>
    ```

  - **支持自增长的数据库**  可以在Insert标签中添加**useGeneratedKeys**和**keyProperty**属性达到效果并且本质与<selectKey标签相同

###### 开发形式

- 代理开发
- 传统开发



##### 操作

###### 创建模块

- 接下来学习的是连接池相关内容
- 项目名称: mybatis-day03-pool

###### 引入依赖

- 数据库驱动
- Mybatis框架包
- log4j日志依赖包(3个)
- c3p0连接池

###### 引入文件

- java文件
  - User.java
  - UserDao.java
  - UserDaoImpl.java

  - SqlSessionKit.java

- 配置文件

  - mybatis.xml
  - userDao.xml
  - db.properties
  - log4j.properties


###### 环境测试

- 创建测试类

  ```java
  
  ```



##### 小结

- 搭建Mybatis项目环境的步骤是怎样的?

  1. 创建项目
  2. 引入依赖
  3. 引入文件
  4. 环境测试



#### 02主配置中数据源类型配置【了解】

##### 目标

- 了解Mybatis连接池3中类型

##### 步骤

- 配置dataSource type=POOLED
- 配置dataSource type=UNPOOLED
- 配置dataSource type=**jndi实现类**

##### 操作

###### 内部连接池

- 配置

  ```xml
  <dataSource type="POOLED">
      <property name="driver" value="${db.driver}"/>
      <property name="url" value="${db.url}"/>
      <property name="username" value="${db.username}"/>
      <property name="password" value="${db.password}"/>
  </dataSource>
  ```

- 测试

  ```java
  @Test
  public void testPooled(){
      testEnv();
      System.out.println("==========分割线=========");
      testEnv();
  }
  ```

###### 不用连接池

- 配置

  ```xml
  <dataSource type="UNPOOLED">
      <property name="driver" value="${db.driver}"/>
      <property name="url" value="${db.url}"/>
      <property name="username" value="${db.username}"/>
      <property name="password" value="${db.password}"/>
  </dataSource>
  ```

- 测试

  ```java
  @Test
  public void testUnPooled(){
      testEnv();
      System.out.println("==========分割线=========");
      testEnv();
  }
  ```

###### 外部连接池

- 创建jndi实现类

  ```java
  /**
   * C3P0DataSourceFactory.
   *
   * @author ：Jason.lee
   * @version : 1.0
   * @date ：2019-4-21 16:13
   * @description : C3P0DataSourceFactory
   * @modified : -
   */
  public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {
  
      public C3P0DataSourceFactory() {
          dataSource = new ComboPooledDataSource();
      }
  }
  ```

- 配置

  ```xml
  <dataSource type="com.itheima.mybatis.day03.pool.jndi.C3P0DataSourceFactory">
      <property name="driverClass" value="${db.driver}"/>
      <property name="jdbcUrl" value="${db.url}"/>
      <property name="user" value="${db.username}"/>
      <property name="password" value="${db.password}"/>
  </dataSource>
  ```

- 测试

  ```java
  @Test
  public void testJndi(){
      testEnv();
      System.out.println("==========分割线=========");
      testEnv();
  }
  ```

##### 小结

- POOLED采用了框架提供的连接池技术, 连接关闭只是放回连接池
- UNPOOLED不采用连接池, 每次执行都是一个新连接
- JNDI采用外部的连接, 同样达到连接关闭只是放回连接池的效果



#### 03主配置中事务类型配置【了解】

##### 目标

- 了解JDBC事务提交的 **2种** 方式

##### 步骤

###### 两种类型

- JDBC: 使用jdbc的设置管理事务
- MANAGED: 使用外部容器管理事务

###### 两种方式

- 手动提交
- 自动提交

##### 操作

###### 添加手动提交操作

```java

```

###### 添加手动提交测试

```java

```



###### 添加自动提交操作

```java

```

###### 添加自动提交测试

```

```



##### 小结

- JDBC类型的事务有哪两种提交方式?
  - 
- MANAGED类型的事务是Mybatis管理的吗?
  - 



#### 04动态语句标签 - if【掌握】

##### 目标

- 掌握if标签的使用方式和细节

##### 步骤

###### 整理需求

- ==根据 **名称和性别** 查找用户==
- ==只根据 **名称** 查找用户==

###### 整理步骤

1. 创建项目(已准备)
2. 引入依赖(已准备)
3. 引入文件(已准备)
4. **添加操作**
5. **添加配置**
6. **添加测试**

##### 操作

###### 添加操作

```java

```

###### 添加配置

```xml

```

###### 添加测试

```java

```

##### 小结

- if标签的作用是什么?
  - 
- 判断时获取参数需要使用#{}或${}吗?
  - 



#### 05动态语句标签 - where【掌握】

##### 目标

- 掌握where标签的用法

##### 步骤

###### 整理需求

- ==只根据 **性别** 查找用户==

###### 整理步骤

1. 测试
2. **使用where标签解决问题**
3. **测试**

##### 操作

###### 配置where

```xml

```

###### 测试

```java

```

##### 小结

- where标签的作用是什么?
  - 
- 使用where要注意什么?
  - 



#### 06动态语句标签 - set【掌握】

##### 目标

- 掌握set标签的用法

##### 步骤

###### 整理需求

- ==更新用户地址和性别==
- ==只更新用户性别==

###### 整理步骤

1. 添加操作
2. 添加配置
3. 测试
4. **使用set解决问题**
5. **测试**

##### 操作

###### 配置set

```xml

```

###### 测试

```xml

```

##### 小结

- set标签的作用是什么?
  - 
- 使用set要注意什么?
  - 



#### 07动态语句标签 - sql【了解】

##### 目标

- 了解sql和include的用法

##### 步骤

###### 整理需求

- ==查询时返回部分字段==

###### 整理步骤

1. 指定字段
2. 测试
3. **使用sql, includes标签**
4. **测试**

##### 操作

###### 配置sql

```xml

```

###### 测试

```java

```

##### 小结

- sql和include标签的作用是什么?
  - 
- 为什么要使用sql标签定义sql片段?
  - 



#### 08动态语句标签 - foreach【掌握】

##### 目标

- 掌握foreach标签的用法

##### 步骤

###### 整理需求

- ==查询id集合中的用户==

###### 整理步骤

1. **添加操作**
2. **配置操作**
3. **测试**

##### 操作

###### 添加操作

```java
/**
 * 根据多个ID查找用户.
 *
 * @param ids id集合
 * @return 查询结果
 */
List<User> findByIds(List<Integer> ids);
```

###### 配置操作

```
<select id="findByIds" parameterType="list" resultType="user">
    SELECT <include refid="fields"/> FROM user
    <where>
        <foreach collection="list" item="id" open="id in(" separator="," close=")">
            #{id}
        </foreach>
    </where>
</select>
```

###### 测试

```java
@Test
public void testForeach(){
    SqlSession sqlSession = SqlSessionKit.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List ids = new ArrayList();
    ids.add(1);
    ids.add(11);
    List<User> users = mapper.findByIds(ids);
    users.forEach(u -> System.out.println(u));
    sqlSession.close();
}
```

##### 小结

- foreach标签的作用是什么?
  - 
- 使用foreach取值时数组和集合有什么不同?
  - 



#### 09映射配置关联查询 - O2O【掌握】

##### 目标

- 掌握1对1关联查询映射配置

##### 步骤

###### 整理需求

- ==查找所有订单并显示关联用户信息==

###### 整理步骤

1. 分析执行语句
2. **创建订单类**
3. **添加操作**
4. 引用用户类
5. **配置关联映射**
6. **测试**

##### 操作

###### 订单类

```

```

###### 添加操作

```java

```

###### 配置映射

```xml

```

###### 测试

```java

```

##### 小结

- 1对1关联可以使用resultType实现吗?
  - 
- ResultMap如何配置关联对象?
  - 





#### 10映射配置关联查询 - O2M【掌握】

##### 目标

- 掌握1对多关联映射配置

##### 步骤

###### 整理需求

- ==查找所有用户并显示关联订单信息==

###### 整理步骤

1. **引用订单集合**
2. **添加操作**
3. **配置映射**
4. **测试**

##### 操作

###### 用户类

```java

```

###### 添加操作

```java

```

###### 配置映射

```xml

```

###### 测试

```

```

##### 小结

- 1对多关联可以使用resultType实现吗?
  - 
- ResultMap如何配置关联集合?
  - 



#### 11映射配置关联查询 - M2M【掌握】

##### 目标

- 掌握多对多关联映射配置

##### 步骤

###### 整理需求

- ==查询所有用户并显示关联角色信息==

###### 整理步骤

1. 执行课前资料语句
2. **创建角色类**
3. 引入角色集合
4. **添加操作**
5. **配置映射**
6. **测试**

##### 操作

###### 角色类

```java

```

###### 添加操作

```java

```

###### 配置映射

```xml

```

###### 测试

```java

```

##### 小结

- 多对多与1对多有什么不同?
  - 



#### 12总结【了解】

##### 连接池

- 数据源可以配置哪些类型?
  - 

##### 动态SQL

- 什么是动态SQL?
  - 
- 哪些标签可以根据参数的不同拼接不同的执行语句?
  - 

##### 关联查询

- 1对1查询有哪几种实现方式?
  - 
- 1对多查询如何配置映射?
  - 
- 多对多与多对一是什么关系?
  - 