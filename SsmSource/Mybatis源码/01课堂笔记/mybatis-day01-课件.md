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

#### 2.3 代码设计

1. 创建工程: mybatis01_source_01

2. 添加依赖: pom.xml

   ```xml
   
   ```

3. 



