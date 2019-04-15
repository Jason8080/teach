#### 01复习Mybatis第1天的内容【了解】

##### 目标

​	巩固Mybatis框架的环境搭建为今天的内容打好基础

##### 步骤

###### 解决问题

1. 频繁开关连接, 浪费资源
2. 结果集处理复杂, 代码重复率高
3. 不能自动设置参数
4. sql语句和连接参数硬编码在java代码中

###### 底层技术

1. mysql
2. c3p0
3. 反射
4. dom4j
5. 动态代理
6. 泛型
7. 工厂设计
8. junit

###### 环境搭建

1. 创建项目 (已准备)
2. 引入依赖 (框架, 驱动包)
3. 创建文件 
   1. 用户类
   2. 操作类
   3. 主配置文件(连接参数)
   4. sql文件(sql语句)
4. 环境测试



##### 操作

###### 创建项目



###### 引入依赖



###### 创建文件

1. User.java
2. UserMapper.java
3. mybatis.xml
4. userMapper.xml

###### 环境测试

1. 会话工具

```java
/**
 * 会话工具类
 */
public class SqlSessionKit {


    /**
     * 主配置文件的输入流
     */
    private InputStream in;
    /**
     * 会话连接
     */
    private SqlSession sqlSession;

    // 初始化工具类
    private static SqlSessionKit kit = new SqlSessionKit();


    /**
     * 获取会话连接
     * @return
     */
    public static SqlSession openSeesion() {
        return kit.sqlSession;
    }

    private SqlSessionKit() {
        try {
            this.in = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            this.sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(){
        kit.sqlSession.close();
    }
}
```

2. 测试入口

   ```java
   /**
    * MybatisTests.
    *
    * @author ：Jason.lee
    * @version : 1.0
    * @date ：2019/4/7 17:10
    * @description : MybatisTests
    * @modified : -
    */
   public class MybatisTests {
   
       public static void main(String[] args) throws IOException {
           // 创建连接
           SqlSession sqlSession = SqlSessionKit.openSeesion();
           // 执行操作
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           List<User> all = mapper.findAll();
           all.forEach(u -> System.out.println(u));
           // 关闭资源
           SqlSessionKit.close();
       }
   }
   ```

##### 小结

1. Mybatis环境搭建分哪几步?

   1. 创建项目
   2. 引入依赖
   3. 创建java类
   4. 创建配置文件
   5. 测试
2. Mybatis有哪几个配置文件?
   1. 主配置文件(连接参数)
   2. sql文件(sql语句)



#### 02使用Mybatis查询数据【掌握】

##### 目标

​	掌握Mybatis查询操作

##### 步骤

###### 整理需求

​	==根据用户ID查询用户==

###### 实现步骤

1. 添加操作
2. 配置操作
3. 单元测试

##### 操作

###### 添加操作

```java
/**
 * 根据ID查找用户.
 *
 * @param id 参数
 * @return 查询结果
 */
User findById(Integer id);
```

###### 配置操作

```xml
<!-- 指定操作名称; 指定封装类; 执行语句 -->
<select id="findById" parameterType="int" resultType="com.itheima.mybatis.day02.crud.model.User">
    select * from user where id = #{id}
</select>
```

###### 单元测试

```java
@Test
public void testFindById(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User u = mapper.findById(24);
    System.out.println(u);
    // 关闭资源
    SqlSessionKit.close();
}
```

##### 小结

1. 映射文件中怎么接受参数?

   使用 parameterType指定参数类型, 并且使用#{}占位符接收参数值

2. 执行语句中使用了什么占位符?

   \#{}:  是参数占位符



#### 03学习写入操作极其细节【掌握】

##### 目标

​	掌握数据写入操作和自增长ID查询的方法

##### 步骤

###### 整理需求

​	==保存用户并返回自增长主键==

###### 开发步骤

1. 添加操作
2. 配置操作
3. 单元测试
4. 查询主键
5. 单元测试

##### 操作

###### 添加操作

```java


    /**
     * 保存用户.
     *
     * @param user the user
     */
    void saveUser(User user);
```

###### 配置操作

```xml
<!-- 指定操作名称; 指定封装类; 执行语句 -->
<insert id="saveUser" parameterType="com.itheima.mybatis.day02.crud.model.User">
    insert into user(id, username, birthday, sex, address)
    values(#{id}, #{username}, #{birthday}, #{sex}, #{address})
</insert>
```

###### 单元测试

```java

    @Test
    public void testSaveUser(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSeesion();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(2);
        u.setUsername("小李");
        u.setBirthday(new Date());
        u.setSex("1");
        u.setAddress("江西");
        mapper.saveUser(u);
        // 提交事务
        sqlSession.commit();
//        System.out.println(u);
        // 关闭资源
        SqlSessionKit.close();
    }
```

###### 查询主键

1. 通用查询

    ```xml
      <!-- 指定操作名称; 指定封装类; 执行语句 -->
      <insert id="saveUser" parameterType="com.itheima.mybatis.day02.crud.model.User">
       <selectKey resultType="int" keyColumn="id" keyProperty="id">
           -- 查询当前连接中最后一个自增长主键值
           select LAST_INSERT_ID()
       </selectKey>
      
       insert into user(username, birthday, sex, address)
       values(#{username}, #{birthday}, #{sex}, #{address})
      </insert>
    ```

2. 简洁写法

   ```xml
   <!-- 指定操作名称; 指定封装类; 执行语句 -->
   <insert id="saveUser" parameterType="com.itheima.mybatis.day02.crud.model.User"
           useGeneratedKeys="true" keyProperty="id">
       <!--<selectKey resultType="int" keyColumn="id" keyProperty="id">
           &#45;&#45; 查询当前连接中最后一个自增长主键值
           select LAST_INSERT_ID()
       </selectKey>-->
   
       insert into user(username, birthday, sex, address)
       values(#{username}, #{birthday}, #{sex}, #{address})
   </insert>
   ```

   注意: 该写法, 不支持自增长主键的数据库无法使用.

###### 单元测试

```java
@Test
public void testSaveUser(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User u = new User();
    u.setUsername("小李");
    u.setBirthday(new Date());
    u.setSex("1");
    u.setAddress("江西");
    mapper.saveUser(u);
    // 提交事务
    sqlSession.commit();

    System.out.println(u);
    // 关闭资源
    SqlSessionKit.close();
}
```

##### 小结

1. 写入操作要注意什么?
   - 需要提交事务
2. 返回自增长主键有几种方式?
   - 使用selectKey标签查询
   - 使用insert标签中的useGeneratedKeys属性打开主键查询功能



#### 04模糊查询的参数接收细节【掌握】

##### 目标

​	掌握模糊查询的拼接方式(%%)

##### 步骤

###### 整理需求

​	==根据部分名称查找用户==

###### 开发步骤

1. 添加操作
2. 配置操作
3. 单元测试

##### 操作

###### 添加操作

```java


    /**
     * 根据部分用户名模糊查询用户.
     *
     * @param username the username
     * @return the list
     */
    List<User> likeByUsername(String username);
```

###### 配置操作

```xml


<!-- 指定操作名称; 指定封装类; 执行语句 -->
<select id="likeByUsername" parameterType="string" resultType="com.itheima.mybatis.day02.crud.model.User">
    select * from user where username like #{username}
</select>

```

###### 单元测试

```java

    @Test
    public void testLikeByUsername(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSeesion();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.likeByUsername("%陈%");
        all.forEach(u -> System.out.println(u));
        // 关闭资源
        SqlSessionKit.close();
    }
```

##### 小结

1. 模糊查询有哪些方式拼接%?

   1. java代码拼接

   2. 在sql文件中使用${}占位符和%拼接

      ${}: 使用时必须用value接收参数

    

2. ${}与#{}的区别是什么?

   |          |        \#{*}         |       ${*}        |
   | :------: | :------------------: | :---------------: |
   | 简单类型 |  *可以是任意字符串   | *只能是 **value** |
   | 对象类型 |     **属性名称**     |   **属性名称**    |
   | 其他结论 | 预编译 **防SQL注入** |    字符串拼接     |

   

#### 05使用Mybatis删改数据【掌握】

##### 目标

​	掌握Mybatis**修改**和**删除**数据的操作

##### 步骤

###### 整理需求

​	1. ==根据ID修改用户数据==

​	2. ==根据ID删除用户数据==

###### 开发步骤

1. 添加操作
2. 配置操作
3. 单元测试

##### 操作

###### 添加操作

```java
/**
 * 修改用户.
 *
 * @param user the user
 */
void updateUser(User user);

/**
 * 删除用户.
 *
 * @param user the user
 */
void deleteUser(User user);
```

###### 配置映射

```xml
<!-- 指定操作名称; 指定封装类; 执行语句 -->
<update id="updateUser" parameterType="com.itheima.mybatis.day02.crud.model.User">
    update user set username=#{username}, birthday=#{birthday}, sex=#{sex}, address=#{address} where id = #{id}
</update>

<!-- 指定操作名称; 指定封装类; 执行语句 -->
<delete id="likeByUsername" parameterType="com.itheima.mybatis.day02.crud.model.User">
    delete from user where id = #{id}
</delete>
```

###### 单元测试

```java
@Test
public void testUpdateUser(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User u = new User();
    u.setId(2);
    u.setUsername("小李3");
    u.setBirthday(new Date());
    u.setSex("1");
    u.setAddress("江西 抚州");
    mapper.updateUser(u);
    // 提交事务
    sqlSession.commit();
    // 关闭资源
    SqlSessionKit.close();
}


@Test
public void testDeleteUser(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User u = new User();
    u.setId(49);
    mapper.deleteUser(u);
    // 提交事务
    sqlSession.commit();
    // 关闭资源
    SqlSessionKit.close();
}
```

##### 小结

1. 修改到删除改动了哪里?

   sql执行语句不一样





#### 06掌握输入输出映射配置【掌握】

##### 目标

​	掌握Mybatis输入输出的映射配置

##### 步骤

###### 整理需求

​	==统计1号用户的下单数==

###### 开发步骤

1. 创建订单类
2. 创建操作类
3. 创建sql文件
4. 引入sql文件
5. 单元测试

##### 操作

###### 创建订单类

```java
/**
 * 订单类.
 * <p>
 *     用于接收订单表数据.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:20
 * @description : Order
 * @modified : -
 */
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;
}
```

###### 创建操作类

```java
/**
 * 订单操作类
 */
public interface OrderMapper {
    /**
     * 统计用户下单数.
     *
     * @param id the id
     * @return the integer
     */
    Integer countOrder(Integer id);
}
```

###### 创建sql文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 指定操作类型(指定文件归属的操作类) -->
<mapper namespace="com.itheima.mybatis.day02.crud.mapper.UserMapper">


    <!-- 指定操作名称; 指定封装类; 执行语句 -->
    <select id="countOrder" resultType="int">
        select count(*) from orders where user_id = #{id}
    </select>


</mapper>
```

###### 引入sql文件

```xml
<mapper resource="mapper/orderMapper.xml"/>
```

###### 单元测试

```java
@Test
public void testCountOrder(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    Integer count = mapper.countOrder(1);
    System.out.println(count);
    // 关闭资源
    SqlSessionKit.close();
}
```

##### 小结

1. 输入类型可以是java对象吗?

   可以(接收参数)

2. 输出类型可以是java对象吗?

   可以(返回值)





#### 07掌握ResultMap输出映射【掌握】

##### 目标

​	掌握ResultMap的基本映射配置

##### 步骤

###### 整理需求

​	==查询所有订单==

###### 开发步骤

1. 添加操作
2. 配置映射
3. 单元测试

##### 操作

###### 添加操作

```java
/**
 * 查询所有订单.
 *
 * @return 查询结果
 */
List<Order> findAll();
```

###### 配置映射

```xml
<resultMap id="OrderMap" type="com.itheima.mybatis.day02.crud.model.Order">
    <result column="user_id" property="userId"/>
</resultMap>

<!-- 指定操作名称; 指定封装类; 执行语句 -->
<select id="findAll" resultType="com.itheima.mybatis.day02.crud.model.Order">
    select * from orders
</select>
```

###### 单元测试

```java
@Test
public void testFindAll(){
    // 创建连接
    SqlSession sqlSession = SqlSessionKit.openSeesion();
    // 执行操作
    OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    List<Order> all = mapper.findAll();
    all.forEach(u -> System.out.println(u));
    // 关闭资源
    SqlSessionKit.close();
}
```

##### 小结

1. ResultMap的作用是什么?

   将数据库字段与java对象属性建立对应关系



#### 08认识Mybatis传统开发【理解】

##### 目标

​	区别代理开发与传统开发两种开发方式

##### 步骤

###### 代理总结

　　之前学习的开发方式都是代理开发, 使用了动态代理技术

- sql文件中namespace必须与操作类全名称完全一致
- sql文件中id必须与操作名称完全一致

###### 传统介绍

​	不使用代理技术动态创建实现类, 以手动实现操作类的方式提供



###### 整理需求

 	1. ==根据ID查找用户==
		2. ==添加新用户==



###### 开发步骤

1. 创建新操作类
2. 创建sql文件
3. 提供实现类
4. 引入sql文件
5. 单元测试



##### 操作

###### 创建操作类

```java

/**
 * 用户操作类
 */
public interface UserDao {
    /**
     * 查询所有用户.
     *
     * @param id the id
     * @return the user
     */
    User findById(Integer id);
}

```

###### 创建sq文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 指定操作类型(指定文件归属的操作类) -->
<mapper namespace="com.itheima.mybatis.day02.crud.mapper.UserDao">

    <!-- 指定操作名称; 指定封装类; 执行语句 -->
    <select id="findById" parameterType="int" resultType="com.itheima.mybatis.day02.crud.model.User">
        select * from user where id =#{id}
    </select>


</mapper>
```

###### 提供实现类

```java

/**
 * 用户操作实现类.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:55
 * @description : UserDaoImpl
 * @modified : -
 */
public class UserDaoImpl implements UserDao{
    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = SqlSessionKit.openSeesion();
        User user = sqlSession.selectOne("com.itheima.mybatis.day02.crud.mapper.UserDao.findById", id);
        return user;
    }
}

```

###### 引入sql文件

```xml
<mapper resource="mapper/userDao.xml"/>
```

###### 单元测试

```java
@Test
public void testFindById(){
    UserDaoImpl dao = new UserDaoImpl();
    User user = dao.findById(24);
    System.out.println(user);
}
```

##### 小结

1. 代理方式与传统方式的区别?

   - 代理方式不需要提供实现类, 但是sql文件中的命名空间和操作名称必须完全与操作类一致
   - 传统方式需要提供实现类, 但是sql文件中的命名空间和操作名称不需要一致

2. 当今企业中应用哪种?

   代理开发方式



#### 09主配置文件引用外部配置【掌握】

##### 目标

​	使用 **外部文件** 配置数据库连接参数 (变量)

##### 步骤

###### 定义 db.properties

###### 引入外部配置

###### 使用示例

###### 引入远程配置

##### 操作

###### 定义 db.properties

```properties
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql:///mybatisdb
db.username=root
db.password=root
```

###### 引入外部配置

```xml
<!-- 引入外部配置 -->
<properties resource="db.properties">
    <!-- 说明外部配置优先 -->
    <property name="db.driver" value="666"/>
</properties>
```

###### 使用示例

```xml
    <property name="driver" value="${db.driver}"/>
    <property name="url" value="${db.url}"/>
    <property name="username" value="${db.username}"/>
    <property name="password" value="${db.password}"/>
```

###### 引入远程配置

```xml
<!-- 引入远程配置 -->
<properties url="http://localhost:8080/db.properties">

</properties>
```

##### 小结

1. 有几种引用方式?

   - 外部配置 (有重复变量以外部为准)
   - 内部配置
   - 远程配置

   

2. 引用内部若配置了与外部文件中相同的变量, 哪个生效?

   最终以外部配置为准

   

#### 10主配置文件配置别名【掌握】

##### 目标

​	学习别名的配置与使用

##### 步骤

###### 内置别名

###### 自定义别名

1. 单独设置
2. 批量设置

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

###### 自定义别名

1. 单独设置

   ```xml
   <!-- 别名设置 -->
   <typeAliases>
       <!-- 单独设置 -->
       <typeAlias type="com.itheima.mybatis.day02.crud.model.User" alias="user"/>
   </typeAliases>
   ```

2. 批量设置

```xml
<!-- 别名设置 -->
<typeAliases>
    <!-- 单独设置 -->
    <!--<typeAlias type="com.itheima.mybatis.day02.crud.model.User" alias="user"/>-->
    <package name="com.itheima.mybatis.day02.crud.model"/>
</typeAliases>
```

##### 小结

1. 如何自定义别名?

   使用typeAliases标签定义对象别名

   - 单独设置是指定全类名
   - 批量设置指定的包名



#### 11批量加载sql配置文件【了解】

##### 目标

​	学习批量加载sql文件

##### 步骤

###### 前提条件

1. 映射文件需要放在映射器同路径下

   **com/itheima/mybatis/day02/crud/mapper**

2. 代理开发方式

   **不支持传统Dao方式**

###### 语法使用

```xml
<!-- 批量配置sql文件路径 -->
<package name="com.itheima.mybatis.day02.crud.mapper"/>
```

##### 操作

##### 小结

1. 批量加载sql文件有哪些前提?
   - 必须是代理开发方式
   - 需要把sql文件放在操作类相同目录下





#### 12总结

1. CRUD操作对应着哪些标签?

   ```xml
   select, update, insert, delete
   ```

2. 模糊查询如何拼接字符?

   - 在java代码中拼接
   - 直接在sql文件中使用占位符在字符串中获取参数( '%${value}%')

3. 输入输出映射有哪些?

   parameterType: 别名

   resultType: 别名

   resultMap: 将数据库字段与java对象属性建立对应关系

4. 传统开发与代理开发的区别是什么?

   - 传统需要提供实现类, 需要在代码中指定操作类型和操作名
   - 代理不需要提供实现类, 但是namespace和id必须与操作类和操作名称一致

5. 常用标签有哪些, 做什么用的, 需要注意什么?

   - <properties resource, ur: 引入外部配置
   - <typeAliases: 设置别名
   - <package: 批量加载sql文件 (不支持传统开发方式)