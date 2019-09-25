

### 01复习

#### 目标

- 了解Mybatis框架特点
- 搭建Mybatis案例环境



#### 1. 框架特点

1. 开源的
2. 持久层的
3. 支持定制化SQL



#### 2. 搭建环境

1. 工程名称: mybatis02_crud_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. Mybatis 依赖 -->
   
   <!-- 2. SpringJdbc 依赖 -->
   
   <!-- 3. Mysql驱动 依赖 -->
   
   <!-- 4. Druid连接池 依赖 -->
   
   <!-- 5. Junit 依赖 -->
   ```

3. 导入配置: sqlMapConfig.xml

   ```xml
   
   ```

4. 创建实体: com.itheima.crud.User

   ```java
   
   ```

5. 添加映射: com.itheima.crud.UserMapper

   ```java
   
   ```

6. 导入映射: userMapper.xml

   ```xml
   
   ```

7. 环境测试: CrudTests

   ```java
   // 1. 创建会话
   // 2. 执行操作
   // 3. 处理结果
   ```

8. 封装工具: com.itheima.crud.SqlSessionKit

   ```java
   
   ```



#### 小结

- Mybatis的配置文件有哪些?

  - 
- Mybatis的开发步骤是哪三步?
  - 



### 02CRUD - 新增操作【掌握】

#### 目标

- 使用Mybatis保存用户
- 获取保存后的自增主键



#### 1. 保存用户

1. 添加保存方法: com.itheima.crud.UserMapper

   ```java
   
   ```

2. 添加保存映射: userMapper.xml

   ```xml
   
   ```

3. 单元测试: CrudTests

   ```java
   // 打印用户编号
   ```



#### 2. 获取主键

1. 通用查询: userMapper.xml

   ```xml
   <!-- select LAST_INSERT_ID() -->
   ```

2. 简洁配置: userMapper.xml

   ```xml
   
   ```

   注意: 需要数据库支持自增脏, 否则 **无法使用**



#### 小结

- 写数据库操作需要事务吗?
  - 

- 如何返回自增长的主键值?
  - 
  - 



### 03CRUD - 删改操作【掌握】

#### 目标

- 使用Mybatis删改用户



#### 1. 删改用户

1. 添加删改方法: com.itheima.crud.UserMapper

   ```java
   
   ```

2. 添加删改映射: userMapper.xml

   ```xml
   
   ```

3. 单元测试: CrudTests

   ```java
   
   ```



#### 小结

- 在Mybatis环境中的业务开发步骤?
  - 
  - 
  - 



### 04CRUD - 查询操作【掌握】

#### 目标

- 使用Mybatis查询用户



#### 1. 查询用户

1. 添加查询方法: com.itheima.crud.UserMapper

   ```java
   
   ```

2. 添加查询映射: userMapper.xml

   ```xml
   
   ```

3. 单元测试: CrudTests

   ```java
   
   ```

   

#### 小结

- 占位符`#{}`的作用是什么?
  - 



### 05占位符的孪生兄弟【掌握】

#### 目标

- 掌握拼接符`${}`的使用
- 拼接符与占位符的区别
- 使用拼接符代替占位符



#### 1. 使用拼接符

1. 添加模糊查询方法: com.itheima.crud.UserMapper

   ```java
   
   ```

2. 添加模糊查询映射: userMapper.xml

   ```xml
   
   ```

3. 单元测试: CrudTests

   ````java
   
   ````



#### 2. `#{}`与`${}`的区别

|          |                   #{*}                   |            ${*}            |
| :------: | :--------------------------------------: | :------------------------: |
| 名称区别 |                  占位符                  |           拼接符           |
| 作用区别 | 通过预编译代替占位符 ( **防止SQL注入** ) |    直接拼接到最终的SQL     |
| 使用区别 |     *可以是任意字符串 (**简单类型**)     | *只能是value ( **3.4.5** ) |



#### 小结

- ${}与#{}的区别是什么?
  - 拼接符: 
  - 占位符: 



### 06标签 - ResultMap【掌握】

#### 目标

- 使用ResultMap映射订单实体



#### 1. 映射订单实体

1. 创建实体: com.itheima.crud.Order

   ```java
   
   ```

2. 添加映射: com.itheima.crud.OrderMapper

   ```java
   
   ```

3. 映射配置: orderMapper.xml

   ```xml
   
   ```

4. 扫描配置: sqlMapConfig.xml

   ```xml
   
   ```

5. 单元测试: OrderTests

   ```java
   
   ```

6. 分析问题: 部分字段查询是空

   - 原因: 
   - 解决: 



#### 小结

- ResultMap的作用是什么?
  - 



### 07开发方式 - 传统开发【理解】

#### 目标

- 分析代理方式开发要求
- 使用传统方式开发需求





#### 1. 代理开发要求

1. 映射文件中namespace与类名 完全一致
2. 映射文件中id与方法名称 完全一致



#### 2. 传统方式开发

1. 改造工程: mybatis02_impl_02

6. 提供实现: com.itheima.crud.UserDaoImpl

   ```java
   
   ```

7. 映射配置: userMapper.xml

   ```xml
   
   ```

8. 单元测试: ImplTests

   ```java
   
   ```



#### 小结

- 传统与代理的区别是什么?

  - 代理:
- 传统: 
  
  
  
  

### 08开发方式 - 注解开发【掌握】

#### 目标

- 使用注解代替映射文件



#### 1. 注解代替映射文件

1. 改造工程: mybatis02_anno_03

2. 改造映射: com.itheima.crud.UserMapper

   ```java
   
   ```

3. 改造配置: sqlMapConfig.xml

   ```xml
   
   ```

4. 单元测试: CrudTests

   ```java
   
   ```



#### 小结

- 使用注解需要改动什么配置?

  - 
- 使用什么注解返回自增主键?
  - 



### 09主配置 - 批量引用【了解】

#### 目标

- 在主配置中批量扫描映射文件
- 了解批量引用映射文件的前提



#### 1. 批量引入映射文件

1. 扫描包路径: sqlMapConfig.xml

   ```xml
   
   ```
   
2. 去除重复操作: userMapper.xml

   ```xml
   
   ```



#### 2. 批量引用的前提

1. 映射文件: 必须放在扫描包名相同目录下
   - com/itheima/crud
2. 代理开发: 传统方式不支持批量扫描映射



#### 小结

- 批量加载sql文件有哪些前提?
  - 
  - 





### 10主配置 - 别名配置【掌握】

#### 目标

- 了解默认支持的别名
- 配置自定义类的别名
- 批量配置自定义别名



#### 1. 默认支持的别名

| 别名       | 映射类型   |
| ---------- | ---------- |
| _byte      | byte       |
| _long      | long       |
| _short     | short      |
| _int       | int        |
| _integer   | int        |
| _double    | double     |
| _float     | float      |
| _boolean   | boolean    |
| string     | String     |
| byte       | Byte       |
| long       | Long       |
| short      | Short      |
| int        | Integer    |
| integer    | Integer    |
| double     | Double     |
| float      | Float      |
| boolean    | Boolean    |
| date       | Date       |
| decimal    | BigDecimal |
| bigdecimal | BigDecimal |
| object     | Object     |
| map        | Map        |
| hashmap    | HashMap    |
| list       | List       |
| arraylist  | ArrayList  |
| collection | Collection |
| iterator   | Iterator   |



#### 2. 配置自定义类的别名

1. 配置别名: sqlMapConfig.xml

   ```xml
   
   ```

2. 使用别名: userMapper.xml

   ```xml
   
   ```



#### 小结

- 标签typeAliases的作用?
  - 



### 11主配置 - 变量配置【掌握】

#### 目标

- 使用变量配置
- 引用外部变量
- 引用远程变量



#### 1. 使用变量配置

1. 定义内部变量: sqlMapConfig.xml

   ```xml
   
   ```

2. 引用外部变量: db.properties  (内外部变量冲突 **以外部为准** )

   ```properties
   
   ```

3. 引用远程变量: sqlMapConfig.xml

   ```xml
   
   ```

   

#### 小结

- 变量的配置方式有哪些?
  - 
  - 
  - 



### 12总结

1. CRUD操作对应着哪些标签?
   - create: 
   - read: 
   - update: 
   - delete: 
2. 占位符与拼接符的区别?
   - #{}: 
   - ${}: 
3. 模糊查询的条件参数如何拼接`%`?
   - 
   - 
4. 输入输出映射有哪些?
   - 
   - 
- 
  
5. 注解@SelectKey的作用?
   - 
6. 传统开发与代理开发的区别是什么?
   - 传统: 
   - 代理: 
7. 批量引用映射文件有什么前提?
   - 
   - 
8. 至少说出主配置文件中的3个标签?
   - 
   - 
   - 

