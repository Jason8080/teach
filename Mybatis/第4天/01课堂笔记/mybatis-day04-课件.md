## 第4天: Mybatis

### 一、学习目标

- 了解Mybatis延迟加载
- 了解Mybatis缓存
- 掌握Mybatis注解开发



### 二、延迟加载

#### 2.1 作用

　　按需查询: 根据需求需要查询相应的数据。

#### 2.2 环境支持

```xml
<settings>
    <!-- 关联对象延迟加载 -->
    <setting name="lazyLoadingEnabled" value="true"/>
    <!-- 任何方法调用触发延迟加载 -->
    <setting name="aggressiveLazyLoading" value="false"/>
</settings>
```

#### 2.3 association

##### 2.3.1 测试

```java
@Test
public void testAssociation(){
    List<Order> all = orderMapper.findAll();
    all.get(0).getId();
    //        all.forEach(o -> System.out.println(o));
    sqlSession.close();
}
```

##### 2.3.2 用法

```xml
<resultMap id="OrderMap" type="com.itheima.mybatis.day02.lazy.model.Order">
    <result column="user_id" property="userId"/>
    <association property="user" javaType="user"
                 column="user_id"
                 select="com.itheima.mybatis.day02.lazy.mapper.UserMapper.findById"/>
</resultMap>
```

```xml
<select id="findById" parameterType="int" resultType="user">
    select * from user where id = #{id}
</select>
```

##### 2.3.3 结果

> DEBUG [main] - ==>  Preparing: select * from user where id = ? 
> DEBUG [main] - ==> Parameters: 24(Integer)
> DEBUG [main] - <==      Total: 1
> User{id=24, username='张三丰', birthday=null, sex='1', address='河南郑州', orders=null}

##### 2.3.4 结论

- lazyLoadingEnabled=true开启懒加载之后支持延迟加载(**按需加载**)

- 当aggressiveLazyLoading=false时, **order.getId()后不会执行findById语句**
- 当aggressiveLazyLoading=true 时, **order.getId()后将会执行findById语句**



#### 2.4 collection

##### 2.4.1 测试

```java

```

##### 2.4.2 用法

```xml

```

```xml

```

##### 2.4.3 结果

> 

##### 2.3.4 结论

- 



### 三、缓存



### 四、注解开发



### 五、总结

