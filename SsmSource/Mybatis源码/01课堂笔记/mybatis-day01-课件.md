## 第1天: Mybatis 源码分析

### 一、目标

1. 理解Mybatis框架 **执行流程**
2. 理解Mybatis框架 **架构设计**
3. 熟悉Mybatis框架 **核心组件**
4. 掌握通过debug **跟踪学习** (源码分析)
5. 掌握Mybatis框架 **常见问题 **(常见面试题)



### 二、Mybatis 应用案例

#### 2.1 需求

1. 完成账户的 **新增** 操作
2. 完成账户的 **修改** 操作
3. 完成账户的 **删除** 操作
4. 完成账户的 **查询** 操作



#### 2.2 环境准备

1. 数据库: mybatisdb

   ```sql
   create database mybatisdb;
   ```

2. 数据库表: account

   ```sql
   SET FOREIGN_KEY_CHECKS=0;
   
   -- ----------------------------
   -- Table structure for account
   -- ----------------------------
   DROP TABLE IF EXISTS `account`;
   CREATE TABLE `account` (
     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `uid` int(11) DEFAULT '1' COMMENT '用户编号',
     `money` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;
   
   -- ----------------------------
   -- Records of account
   -- ----------------------------
   INSERT INTO `account` VALUES ('1', '1', '10.00');
   INSERT INTO `account` VALUES ('2', '10', '0.00');
   INSERT INTO `account` VALUES ('3', '24', '99.00');
   ```

#### 2.3 代码环境

1. 创建工程: mybatis01_source_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. 添加Mybatis框架依赖 -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.0</version>
   </dependency>
   <!-- 2. 添加Mysql驱动依赖 -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.18</version>
   </dependency>
   <!-- 3. 添加Junit框架依赖 -->
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
   </dependency>
   <!-- 4. 添加Log4j工具依赖-->
   <dependency>
       <groupId>log4j</groupId>
       <artifactId>log4j</artifactId>
       <version>1.2.17</version>
   </dependency>
   ```

3. 实体设计: com.itheima.mybatis.domain.Account

   ```java
   package com.itheima.mybatis.domain;
   
   /**
    * 账户类.
    *  - 数据模型
    * @author : Jason.lee
    * @version : 1.0
    */
   public class Account {
       private Integer id;
       private Integer uid;
       private Double money;
   
       public Integer getId() {
           return id;
       }
   
       public void setId(Integer id) {
           this.id = id;
       }
   
       public Integer getUid() {
           return uid;
       }
   
       public void setUid(Integer uid) {
           this.uid = uid;
       }
   
       public Double getMoney() {
           return money;
       }
   
       public void setMoney(Double money) {
           this.money = money;
       }
   
       @Override
       public String toString() {
           return "Account{" +
                   "id=" + id +
                   ", uid=" + uid +
                   ", money=" + money +
                   '}';
       }
   }
   ```

#### 2.4 代码开发

1. 接口设计: com.itheima.mybatis.dao.AccountDao

   ```java
   package com.itheima.mybatis.dao;
   
   import com.itheima.mybatis.domain.Account;
   
   import java.util.List;
   
   /**
    * 账户持久层接口.
    * - Mybatis操作类
    *
    * @author : Jason.lee
    * @version : 1.0
    */
   public interface AccountDao {
   
   
       /**
        * 保存账户.
        *
        * @param account 账户信息
        */
       void save(Account account);
   
       /**
        * 修改账户.
        *
        * @param account 账户信息
        */
       void update(Account account);
   
       /**
        * 删除账户.
        *
        * @param account 账户信息
        */
       void del(Account account);
   
       /**
        * 查询所有账户.
        *
        * @return 查询结果
        */
       List<Account> findAll();
   
   }
   ```

2. 实现类: com.itheima.mybatis.dao.impl.AccountDaoImpl

   ```java
   package com.itheima.mybatis.dao.impl;
   
   import com.itheima.mybatis.dao.AccountDao;
   import com.itheima.mybatis.domain.Account;
   import org.apache.ibatis.session.SqlSession;
   import org.apache.ibatis.session.SqlSessionFactory;
   
   import java.util.List;
   
   /**
    * Mybatis传统开发.
    *  - 手动调用API操作数据库
    * @author : Jason.lee
    * @version : 1.0
    */
   public class AccountDaoImpl implements AccountDao {
   
       private SqlSessionFactory sqlSessionFactory;
   
       public AccountDaoImpl(SqlSessionFactory sqlSessionFactory) {
           this.sqlSessionFactory = sqlSessionFactory;
       }
   
       @Override
       public void save(Account account) {
           // 1. 获取连接
           SqlSession sqlSession = sqlSessionFactory.openSession();
           // 2. 执行操作
           sqlSession.insert("com.itheima.mybatis.dao.AccountDao.save", account);
           // 3. 提交事务
           sqlSession.commit();
           sqlSession.close();
       }
   
       @Override
       public void update(Account account) {
           // 1. 获取连接
           SqlSession sqlSession = sqlSessionFactory.openSession();
           // 2. 执行操作
           sqlSession.insert("com.itheima.mybatis.dao.AccountDao.update", account);
           // 3. 提交事务
           sqlSession.commit();
           sqlSession.close();
       }
   
       @Override
       public void del(Account account) {
           // 1. 获取连接
           SqlSession sqlSession = sqlSessionFactory.openSession();
           // 2. 执行操作
           sqlSession.insert("com.itheima.mybatis.dao.AccountDao.del", account);
           // 3. 提交事务
           sqlSession.commit();
           sqlSession.close();
       }
   
       @Override
       public List<Account> findAll() {
           // 1. 获取连接
           SqlSession sqlSession = sqlSessionFactory.openSession();
           // 2. 执行操作
           // 3. 返回结果
           return sqlSession.selectList("com.itheima.mybatis.dao.AccountDao.findAll");
       }
   }
   ```

3. 映射文件: com/itheima/mybatis/dao/AccountDao.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.itheima.mybatis.dao.AccountDao">
   
       <!-- 保存账户 -->
       <select id="save" parameterType="account">
           insert into account values(#{id}, #{uid}, #{money})
       </select>
       <!-- 修改账户 -->
       <select id="update" parameterType="account">
           update account set money = #{money} where id = #{id}
       </select>
       <!-- 删除账户 -->
       <select id="del" parameterType="account">
           delete from account where id = #{id}
       </select>
       <!-- 查询账户 -->
       <select id="findAll" resultType="account">
           select * from account
       </select>
   
   </mapper>
   ```

4. 配置文件: sqlMapConfig.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
       <!-- 1. 导入外部配置文件 -->
       <properties resource="db.properties"/>
       <!-- 2. 配置实体类别名 -->
       <typeAliases>
           <package name="com.itheima.mybatis.domain"/>
       </typeAliases>
       <!-- 3. 配置Mybatis环境 -->
       <environments default="test">
           <environment id="test">
               <transactionManager type="JDBC"></transactionManager>
               <dataSource type="POOLED">
                   <property name="driver" value="${db.driver}"/>
                   <property name="url" value="${db.url}"/>
                   <property name="username" value="${db.username}"/>
                   <property name="password" value="${db.password}"/>
               </dataSource>
           </environment>
       </environments>
       <!-- 4. 扫描映射配置文件 -->
       <mappers>
           <package name="com.itheima.mybatis.dao"/>
       </mappers>
   </configuration>
   ```

#### 2.5 单元测试

##### 2.5.1 传统方式

- ApiTests: 需要提供实现类

  ```java
  import com.itheima.mybatis.dao.AccountDao;
  import com.itheima.mybatis.dao.impl.AccountDaoImpl;
  import com.itheima.mybatis.domain.Account;
  import org.apache.ibatis.io.Resources;
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.ibatis.session.SqlSessionFactoryBuilder;
  import org.junit.Before;
  import org.junit.Test;
  
  import java.io.IOException;
  import java.io.InputStream;
  import java.util.List;
  
  /**
   * Mybatis传统方式开发测试.
   *  传统方式开发的特点:
   *      1. 需要提供持久层实现类
   *      2. 手动调用Api操作数据库
   *
   * @author : Jason.lee
   * @version : 1.0
   */
  public class ApiTests {
  
      AccountDao accountDao;
  
  
      @Before
      public void before() throws Exception {
          // 1. 加载配置文件
          InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
          // 2. 构建会话工厂
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
          // 3. 创建持久层实现类
          accountDao = new AccountDaoImpl(sqlSessionFactory);
      }
  
      @Test
      public void testSave(){
          Account account = new Account();
          account.setId(10);
          account.setUid(10);
          account.setMoney(10D);
          accountDao.save(account);
      }
  
      @Test
      public void testUpdate(){
          Account account = new Account();
          account.setId(10);
          account.setMoney(11D);
          accountDao.update(account);
      }
  
      @Test
      public void testDel(){
          Account account = new Account();
          account.setId(10);
          accountDao.del(account);
      }
  
      @Test
      public void testFind(){
          List<Account> all = accountDao.findAll();
          all.forEach(x -> System.out.println(x));
      }
  
  }
  ```

##### 2.5.2 代理方式

- ProxyTests: 不需要实现类 (namespace,id必须与interface,method完全一致)

  ```java
  import com.itheima.mybatis.dao.AccountDao;
  import com.itheima.mybatis.dao.impl.AccountDaoImpl;
  import com.itheima.mybatis.domain.Account;
  import org.apache.ibatis.io.Resources;
  import org.apache.ibatis.session.SqlSession;
  import org.apache.ibatis.session.SqlSessionFactory;
  import org.apache.ibatis.session.SqlSessionFactoryBuilder;
  import org.junit.After;
  import org.junit.Before;
  import org.junit.Test;
  
  import java.io.InputStream;
  import java.util.List;
  
  /**
   * Mybatis代理方式开发测试.
   *  代理方式开发的特点:
   *      1. 不需要提供持久层实现类
   *      2. 根据会话对象自动生成代理类
   *
   * @author : Jason.lee
   * @version : 1.0
   */
  public class ProxyTests {
  
      SqlSession sqlSession;
      AccountDao accountDao;
  
  
      @Before
      public void before() throws Exception {
          // 1. 加载配置文件
          InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
          // 2. 构建会话工厂
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
          // 3. 获取会话对象
          sqlSession = sqlSessionFactory.openSession();
          // 4. 生成代理对象
          accountDao = sqlSession.getMapper(AccountDao.class);
      }
  
      @After
      public void after(){
          // 5. 最后提交事务
          sqlSession.commit();
          sqlSession.close();
      }
  
      @Test
      public void testSave(){
          Account account = new Account();
          account.setId(10);
          account.setUid(10);
          account.setMoney(10D);
          accountDao.save(account);
      }
  
      @Test
      public void testUpdate(){
          Account account = new Account();
          account.setId(10);
          account.setMoney(11D);
          accountDao.update(account);
      }
  
      @Test
      public void testDel(){
          Account account = new Account();
          account.setId(10);
          accountDao.del(account);
      }
  
      @Test
      public void testFind(){
          List<Account> all = accountDao.findAll();
          all.forEach(x -> System.out.println(x));
      }
  
  }
  
  ```



### 三、框架的执行流程

#### 3.1 代码回顾: ProxyTests

```java
@Before
public void before() throws Exception {
    // 1. 加载配置文件
    InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
    // 2. 构建会话工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    // 3. 获取会话对象
    sqlSession = sqlSessionFactory.openSession();
    // 4. 生成代理对象
    accountDao = sqlSession.getMapper(AccountDao.class);
}
```



#### 3.2 流程分析

![image-20191208115629337](assets/Myabtis框架执行流程图.png)

1. 加载配置文件: sqlMapConfig.xml
   - 加载映射文件: accountDao.xml
2. 解析配置文件 *
   - 将sqlMapConfig.xml文件中的内容封装到对象: Configuration
   - 将accountDao.xml文件中的内容封装到对象: MappedStatement
   - 返回SqlSessionFactory对象
3. 获取会话对象
   - 返回SqlSession对象
4. 获取代理对象
   - 返回代理对象
5. 执行查询操作 *
   - 通过MappedStatement的id值获取相应的SQL语句
   - 根据MappedStatement的parameterType值处理SQL语句中的占位符
   - 调用SQL语句执行工具Executor执行最终的SQL
6. 返回结果映射 *
   - 根据MappedStatement的resultType/resultMap封装结果集返回



### 四、Mybatis 架构设计

![image-20191208160702818](assets/Mybatis框架架构设计-接口层.png)

![image-20191208160748828](assets/Mybatis框架架构设计-数据处理层.png) 

![image-20191208160824019](assets/Mybatis框架架构设计-框架支撑层.png)

![image-20191208160917137](assets/Mybatis框架架构设计-引导层.png)   



#### 4.1 接口层 *

> ​	提供给外部使用的接口API，开发人员通过这些本地API来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。 例: AccountDao

####  4.2 数据处理层

> ​	负责具体的SQL查找、SQL解析、SQL执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。例: SqlSource, ParameterHandler, Executor, ResultSetHandler

1. 通过Statement ID和参数，构建出动态sql语句
2. 通过sql语句，执行数据库操作
3. 通过sql语句执行结果，完成结果集数据的封装

#### 4.3 框架支撑层

> ​	负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理，这些都是共用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支撑。 例: Cache, Transaction

1. 作为持久层ORM框架，事务管理机制是必备的
2. 作为持久层的ORM框架，连接池管理是必备的
3. 为了提高数据利用率、和系统性能，mybatis框架提供了一级缓存(会话级)和二级缓存(Mapper级)。
4. 在应用层面，mybatis框架提供了基于xml的配置方式，和更加面向接口的注解配置方式

#### 4.4 引导层 *

> ​	提供框架引导的API, 也就是启动框架的代码。 以下例子皆来源于官网。

##### 例1: XML方式

```java
String resource = "org/mybatis/example/mybatis-config.xml";

InputStream inputStream = Resources.getResourceAsStream(resource);

SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
```

##### 例2: Java Api方式

```java
DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();

TransactionFactory transactionFactory = new JdbcTransactionFactory();

Environment environment = new Environment("development", transactionFactory, dataSource);

Configuration configuration = new Configuration(environment);

configuration.addMapper(BlogMapper.class);

SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
```



### 五、Mybatis 核心组件

#### 5.1 Mybatis核心组件表

| 序号 | 组件名称                 | 组件描述                                                     |
| ---- | ------------------------ | ------------------------------------------------------------ |
| 1    | Configuration            | 用于封装、维护Mybatis框架的所有配置信息                      |
| 2    | MappedStatement          | 每个MappedStatement，封装维护了一个<select\|update\|delete\|insert>节点 |
| 3    | SqlSessionFactoryBuilder | 构建器，用于解析封装主配置文件内容，构建SqlSessionFactory核心对象 |
| 4    | SqlSessionFactory        | 工厂类接口，通过工厂方法openSession创建SqlSession对象        |
| 5    | SqlSession               | Mybatis框架的顶层API，表示和数据库交互的会话，提供了完成数据库增删改查操作的接口方法 |
| 6    | Executor                 | Mybatis框架执行器，是框架的调度核心，负责sql语句的生成和查询缓存维护 |
| 7    | StatementHandler         | 封装Jdbc Statement操作，比如设置参数、将Statement结果集转换成List |
| 8    | ParameterHandler         | 将用户传递的参数，转换成Jdbc Statement 所需要的参数          |
| 9    | SqlSource                | 根据用户传递的ParameterObject，动态生成sql语句，将信息封装到BoundSql对象中 |
| 10   | BoundSql                 | 动态生成的sql语句、和参数信息                                |
| 11   | ResultSetHandler         | 将jdbc返回的ResultSet结果集对象，进行结果集封装，转换成List类型的集合 |
| 12   | TypeHandler              | 类型处理器，完成java数据类型和jdbc数据类型之间的映射和转换   |

#### 5.2 Mybatis核心组件结构

![image-20191208160917137](assets/Mybatis框架核心组件层次&职责.png)



### 六、Mybatis 源码分析

#### 6.1 学习目标

1. 熟练debug工具的使用
2. 跟踪配置文件(sqlMapConfig.xml)的加载



#### 6.2 Debug使用

1. 在入口方法中调用源代码: 如下第4行

    ```java
    @Before
    public void before() throws Exception {
        // 1. 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2. 构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 3. 获取会话对象
        sqlSession = sqlSessionFactory.openSession();
        // 4. 生成代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    ```

1. 进入源代码所在位置, 在需要调试的位置打下断点

    ![image-20191208170112311](assets/image-20191208170112311.png) 

1. 以Debug方式运行代码, 图示如下

    ![image-20191208170541537](assets/image-20191208170541537.png)

1. Debug模式界面示例

    ![image-20191208171624561](assets/image-20191208171624561.png) 

1. 步入: 进入方法内部

    ![image-20191208172235833](assets/image-20191208172235833.png)

1. 强入: 强迫进入方法内部, 暴力提取源代码

    ![image-20191208173534271](assets/image-20191208173534271.png) 

1. 下一步: 进行下一行代码的调试

    ![image-20191208172402448](assets/image-20191208172402448.png) 

1. 步出: 返回上一层调用方法内部

    ![image-20191208172552964](assets/image-20191208172552964.png) 

1. 放行: 调试完毕 或 进入下一个断点位置



#### 6.3 跟踪: 配置文件的加载

##### 6.3.1 牛刀小试

> ​	跟踪技巧: 盯着传进去 **参数** 不放, 直到得到正确的 **返回值** 为止

1. 进入Mybatis框架加载文件的位置

   ```java
   InputStream getResourceAsStream(String resource, ClassLoader[] classLoader) {
       ClassLoader[] var3 = classLoader;
       int var4 = classLoader.length;
   
       for(int var5 = 0; var5 < var4; ++var5) {
           ClassLoader cl = var3[var5];
           if (null != cl) {
               // 源代码54行: org.apache.ibatis.io.ClassLoaderWrapper
               InputStream returnValue = cl.getResourceAsStream(resource);
               if (null == returnValue) {
                   returnValue = cl.getResourceAsStream("/" + resource);
               }
   
               if (null != returnValue) {
                   return returnValue;
               }
           }
       }
   
       return null;
   }
   ```

2. 进入JDK加载文件的位置

   ```java
   public URL findResource(final String name) {
       // 源代码569行: java.net.URLClassLoader
       URL url = AccessController.doPrivileged(
           new PrivilegedAction<URL>() {
               public URL run() {
                   // 【提示】: 进入该行需要暴力提取源码: 即点击【强入】按钮
                   return ucp.findResource(name, true);
               }
           }, acc);
   
       return url != null ? ucp.checkURL(url) : null;
   }
   ```

   ```java
   public URL findResource(String var1, boolean var2) {
       int[] var4 = this.getLookupCache(var1);
   
       URLClassPath.Loader var3;
       for(int var5 = 0; (var3 = this.getNextLoader(var4, var5)) != null; ++var5) {
           // 源代码155行: sun.misc.URLClassPath
           // 【提示】: 当var5遍历第27时可以找到文件
           URL var6 = var3.findResource(var1, var2);
           if (var6 != null) {
               return var6;
           }
       }
   
       return null;
   }
   ```

##### 6.3.2 研究成果

1. 发现JDK默认从targer目录查找配置文件
2. 源码中有对文件名编码, 所以文件名的字符集问题已解决

    ```java
    Resource getResource(final String var1, boolean var2) {
        try {
            // 源代码533行: sun.misc.URLClassPath
            // 【提示】: this = UrlClassPath$FileLoader
            // 【提示】: this.getBaseURL() = target/classes
            // 【成果】: 现JDK默认从targer目录查找配置文件
            URL var4 = new URL(this.getBaseURL(), ".");
            // 【成果】: 对文件名编码
            final URL var3 = new URL(this.getBaseURL(), ParseUtil.encodePath(var1, false));
            if (!var3.getFile().startsWith(var4.getFile())) {
                return null;
            } else {
    ```



> ​	温馨提示: 如果发现配置文件没有找到的问题, 应确保target/classes包下是否存在 !!!





