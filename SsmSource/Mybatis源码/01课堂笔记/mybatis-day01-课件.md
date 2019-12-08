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

  

