#### 01复习【了解】

##### 目标

- 复习Mybatis框架案例
- 复习Myabtis环境搭建

##### 步骤

###### Mybatis解决了哪些问题

1. 频繁开关连接, 浪费资源
2. 结果集处理复杂, 代码重复率高
3. 不能自动设置参数
4. sql语句和连接参数硬编码在java代码中

###### 自定义框架依赖了哪些技术

1. mysql
2. c3p0
3. 反射
4. dom4j
5. 动态代理
6. 泛型
7. 工厂设计
8. junit

###### 创建新的项目

1. 环境测试

   ```java
   
   ```

2. 封装SqlSessionKit工具类

   ```java
   
   ```

##### 小结

- Mybatis的配置文件有哪些?

1. 

- Mybatis的开发步骤是哪三步?

1. 



#### 02CRUD - 新增操作【掌握】

##### 目标

- 使用Mybatis保存数据
- 即时获取到自增长主键值

##### 步骤

- ==保存用户==

1. UserMapper.java: 增加 **save** 操作方法
2. userMapper.xml: 增加 **save** 方法配置
3. **保存测试**
4. **返回自增长的主键值**
5. 测试打印新增的用户ID

##### 操作

###### 增加 save 操作方法

```java

```

###### 增加 save 方法配置

```xml

```

###### 保存测试

```java

```

###### 返回自增长的主键值

1. 通用写法

    ```xml
    
    ```

2. 简洁写法

   ```xml
   
   ```

   注意: 该写法, **不支持自增长主键的数据库无法使用**.



##### 小结

1. 保存/修改/删除类的操作要注意什么?
   - 
2. 如何返回自增长的主键值?
   - 



#### 03CRUD - 删改操作【掌握】

##### 目标

- ==根据ID修改用户数据==
- ==根据ID删除用户数据==

##### 步骤

1. UserMapper.java: 增加 **update、delete** 操作方法
2. userMapper.xml: 增加 **update、delete** 方法配置
3. **测试修改、删除操作**

##### 操作

###### 增加 **update、delete** 操作方法

```java

```

###### 增加 **update、delete** 方法配置

```xml

```

###### 测试修改、删除操作

```java

```

##### 小结

- 修改和删除本质上只是sql语句的变化



#### 04CRUD - 查询操作【掌握】

##### 目标

- ==根据用户ID查询用户==

##### 步骤

1. UserMapper.java: 增加 **findById** 操作方法
2. userMapper.xml: 增加 **findById** 方法的配置
3. **测试ID查询**

##### 操作

###### 增加 findById 操作方法

```java

```

###### 增加 findById 方法的配置

```xml

```

###### 测试ID查询

```java

```

##### 小结

- 映射文件中怎么接受参数?



- 执行语句中使用了什么占位符?





#### 05占位符的孪生兄弟【掌握】

##### 目标

- 使用 **${}** 拼接符
- 代替 **#{}** 占位符

##### 步骤

- ==根据用户名模糊查找用户==

1. UserMapper.java: 增加 **likeByUsername** 操作方法
2. userMapper.xml: 增加 **likeByUsername** 方法的配置
3. **测试模糊查询**

##### 操作

###### 增加 likeByUsername 操作方法

```java

```

###### 增加 likeByUsername 方法的配置

```xml

```

###### 测试模糊查询

```java

```

##### 小结

- ${}与#{}的区别是什么?

|          |        \#{*}         |       ${*}        |
| :------: | :------------------: | :---------------: |
| 简单类型 |  *可以是任意字符串   | *只能是 **value** |
| 对象类型 |     **属性名称**     |   **属性名称**    |
| 其他结论 | 预编译 **防SQL注入** |    字符串拼接     |

- parameterType可以不写吗?

  



#### 06输出映射 - resultType【掌握】

##### 目标

- 映射文件中**接收参数** - 输入映射
- 映射文件中**返回结果** - 输出映射

##### 步骤

- ==统计1号用户的下单数==

1. 创建**Order.java**
2. 创建**OrderMapper.java**
3. 创建**orderMapper.xml**
4. 在mybatis.xml文件中**引用orderMapper.xml文件**
5. **统计测试**

##### 操作

###### 创建Order.java

```java

```

###### 创建OrderMapper.java

```java

```

###### 创建orderMapper.xml

```xml

```

###### 在mybatis.xml文件中引用orderMapper.xml文件

```xml

```

###### 统计测试

```java

```

##### 小结

- 输入类型可以是java对象吗?

  

- 输出类型可以是java对象吗?

  



#### 07输出映射 - ResultMap【掌握】

##### 目标

- ==查询所有订单==

##### 步骤

1. OrderMapper.java: 增加 **findAll** 操作方法
2. orderMapper.xml: 增加 **findAll** 方法配置
3. **测试订单查询**

##### 操作

###### 增加 findAll 操作方法

```java

```

###### 增加 findAll 方法配置

```xml

```

###### 测试订单查询

```java

```

##### 小结

- ResultMap的作用是什么?

  将数据库字段与java对象属性建立对应关系

- 每个 **映射文件** 中都可以配置ResultMap吗?

  可以, 不止每个文件中可以配置, 而且每个文件中都可以配置多个



#### 08映射文件 - 批量引用【了解】

##### 目标

- 在主配置文件中批量引入映射文件

##### 步骤

###### 用法

```xml

```

###### 前提

1. 映射文件需要放在映射器同路径下

   **com/itheima/mybatis/day02/crud/mapper**

2. 代理开发方式

   **不支持传统Dao开发方式**



##### 操作

##### 小结

- 批量加载sql文件有哪些前提?
  - 需要把sql文件放在操作类相同目录下
  - 必须是代理开发方式



#### 09开发方式 - 传统开发【理解】

##### 目标

- 使用传统方式开发需求

##### 步骤

###### 代理总结

　　之前学习的开发方式都是代理开发, 使用了动态代理技术

- sql文件中namespace必须与操作类全名称 **完全一致**
- sql文件中id必须与操作名称 **完全一致**

###### 传统介绍

​	不使用代理技术动态创建实现类, 以手动实现操作类的方式提供

- sql文件中namespace命名 **没有要求**
- sql文件中id命名 **没有要求**

###### 整理需求

- ==根据ID查找用户==
- ==添加新用户==

1. 创建 **UserMapper.java**
2. 创建 **userMapper.xml**
3. 提供实现类 **UserMapperImpl.java**
4. 在mybatis.xml文件中 **引用userMapper.xml文件**
5. **传统开发测试**



##### 操作

###### 创建 UserMapper.java

```java

```

###### 创建 userMapper.xml

```xml

```

###### 提供实现类 UserMapperImpl.java

```java

```

###### 在mybatis.xml文件中 引用orderMapper.xml文件

```xml

```

###### 传统开发测试

```java

```

##### 小结

- 主流的Myabtis开发方式是哪种?

  



#### 10主配置 - 别名配置【掌握】

##### 目标

- 使用简短的别名代替较长的类名

##### 步骤

###### 已经用过哪些别名

- 

###### 能否自定义别名

- 

###### 可否批量设置别名

- 

##### 操作

###### 内置别名

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

###### 单独设置别名

```xml

```

###### 批量设置别名

```xml

```



##### 小结

1. 如何自定义别名?

   使用typeAliases标签定义对象别名

   - 单独设置是指定全类名
   - 批量设置指定的包名



#### 11主配置 - 外部配置【掌握】

##### 目标

- 使用变量代替连接参数

##### 步骤

###### 使用示例[官网](http://www.mybatis.org/mybatis-3/zh/getting-started.html)

###### 定义内部变量

###### 引用外部文件

###### 创建外部文件

###### 引入远程配置

##### 操作

###### 定义内部变量

```xml

```

###### 引用外部文件

```xml

```

###### 创建外部文件

```properties

```

###### 引入远程配置

```xml

```

##### 小结

1. 有几种引用方式?

   - 外部配置 (有重复变量以外部为准)
   - 内部配置
   - 远程配置

   


#### 12总结

- CRUD操作对应着哪些标签?

```xml
select, update, insert, delete
```
- 模糊查询如何拼接字符?
  - 在java代码中拼接
  - 直接在sql文件中使用占位符在字符串中获取参数( '%${value}%')
- 输入输出映射有哪些?
  - parameterType: 别名
  - resultType: 别名
  - resultMap: 将数据库字段与java对象属性建立对应关系
- 传统开发与代理开发的区别是什么?
  - 传统需要提供实现类, 需要在代码中指定操作类型和操作名
  - 代理不需要提供实现类, 但是namespace和id必须与操作类和操作名称一致
- 常用标签有哪些, 做什么用的, 需要注意什么?
  - <properties resource: 引入外部配置
  - <typeAliases: 设置别名
  - <package: 批量加载sql文件 (不支持传统开发方式)