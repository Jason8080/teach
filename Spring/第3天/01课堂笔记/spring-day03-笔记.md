### 01复习【了解】

#### 目标

- 了解常见的面试题



#### 1. 了解常见的面试题

##### 1.1 IOC的底层是什么

- IOC底层是将对象创建转交给工厂完成 (控制反转)
- 并且在工厂中维护了Map存储单例的对象



##### 1.2 Spring的Bean都是单例的吗

- 默认都是单例的
- 在IOC创建的期间会将Bean一起创建并存储
- 可以设置为多例模式
- 多例模式的Bean不会存储在IOC中



##### 1.3 工厂设计模式有什么好处

- 代码解耦: 不用关心对象创建的过程
- 消除重复: 创建对象的过程可以重复使用



#### 小结

- IOC常见对象的注解有哪些?
  - 
- IOC中学习了哪些设计模式?
  - 
  - 



### 02代理模式【了解】

#### 目标

- 了解什么是代理模式
- 实现静态代理的案例




#### 1. 什么是代理模式

- 提供代理类 **控制(拦截)外部对目标对象的访问** 的一种代码设计

![1562124381705](assets/1562124381705.png) 



#### 2. 静态代理的案例

##### 2.1 搭建环境

- 工程名称: spring-day03-proxy
- pom.xml

```xml

```

- Star.java

```xml

```

- 目标对象: LiuStar.java

```java

```

- 代理对象: LiuStarProxy.java

```java

```



##### 2.2 创建代理

- LiuStarProxyTests.java

```java

```



#### 小结

- 什么是代理模式?
  - 
- 目标对象是哪个?
  - 
- 代理对象是哪个?
  - 
- 静态代理的特点?
  - 



### 04动态代理-jdk【理解】

#### 目标

- 了解动态代理的特点
- jdk动态代理的案例



#### 1. 动态代理的特点

- 代理对象在代码运行时创建
- 常见的动态代理有jdk,cglib两种



#### 2. jdk动态代理案例

- Proxy: 官网API

```java
public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
                               throws IllegalArgumentException
```

- LiuStarProxyTests.java

```java

```



#### 小结

- 动态代理有什么特点?
  - 
- 常见的动态代理有哪两种?
  - 



### 05动态代理-cglib【理解】

#### 目标

- cglib动态代理的案例
- 两种动态代理的区别



#### 1. cglib动态代理的案例

- Enhancer: 官网API

```java
public static Object create(java.lang.Class superclass,
                                      java.lang.Class[] interfaces,
                                      Callback[] callbacks)
```

- LiuStarProxyTests.java

```java

```



#### 2. 两种动态代理的区别

|          | JDK                                           | CGLIB                                |
| -------- | --------------------------------------------- | ------------------------------------ |
| 实现方式 | 利用 **实现** 接口方法来拦截目标方法          | 利用 **继承** 覆写方法来拦截目标方法 |
| 实现前提 | 目标对象 **需要实现接口**                     | 需要目标方法未使用final/static修饰   |
| 实现效率 | JDK1.6以前较Cglib慢; 1.6以及1.7大量调用时较慢 | 1.8时被JDK代理超越                   |



#### 小结

- 常见的动态代理有哪些?
  - 

- 两种动态代理有什么区别?
  - 



### 05AOP的概念及术语【理解】

#### 目标

- 理解什么是AOP
- 理解AOP相关的术语



#### 1. 什么是AOP

##### 1.1 AOP的概念

- AOP (Aspect Oriented Programming) 即面向切面编程思想

##### 1.2 AOP的作用

- 在不修改目标对象的情况下对业务进行 **增强**

##### 1.3 AOP的原理

- 底层使用动态代理技术实现AOP切面编程思想



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
- 请描述下列属于的含义:
  - 连接点: 
  - 切入点: 
  - 通知: 
  - 切面: 



### 06AOP的XML案例【掌握】

#### 目标

- 使用AOP实现自动记录日志的功能



#### 1. AOP实现自动记录日志

##### 1.1 搭建环境

- 工程名称: spring-day03-xml

- 添加依赖: pom.xml

```xml

```

- AccountServiceImpl.java

```java

```

- LogAdvice.java

```java

```

- applicationContext.xml

```xml

```

- XmlTests.java

```java

```



##### 1.2 AOP配置

- applicationContext.xml

```xml

```



##### 1.3 单元测试

```java

```





#### 小结

- 什么是通知?
  - 
- 记录日志的类用术语怎么说?
  - 
- 记录日志的方法用术语怎么说?
  - 



### 07切入点表达式【理解】

#### 目标

- 理解什么是切入点表达式
- 了解切入点表达式指示符



#### 1. 什么是切入点表达式

- 描述切入点位置的一种语法规则



#### 2. 切入点表达式指示符

- 切入点表达式常见的 指示符 (PCD)有以下三种

| 指示符        | 示例                                                    | 作用(细粒度)        |
| ------------- | ------------------------------------------------------- | ------------------- |
| bean          | bean(accountService)                                    | 精确到IOC容器的bean |
| within        | within(com.itheima.xml.service.impl.AccountServiceImpl) | 精确到类            |
| **execution** | execution(public void com.itheima..save(..))            | **精确到方法**      |

##### 2.1 bean

- pointcut.xml

```

```

##### 2.2 within

- pointcut.xml

```xml

```

##### 2.3 execution

- pointcut.xml

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





### 08AOP的通知类型【了解】

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

- **通知类型**: 前置通知、后置通知、异常通知、最终通知
- LogAdvice.java

```java

```

- advice.xml

```xml

```



#### 小结

- 通知分为哪几类?
  - 



### 09AOP的环绕通知【掌握】

#### 目标

- 掌握通用通知 ── 环绕通知
- 掌握环绕通知的优点



#### 1. 环绕通知

- advice.xml

```xml

```

- LogAdvice.java

```java

```



#### 小结

- 环绕通知的优点?
  - 



### 10AOP的注解案例【理解】

#### 目标

- 使用AOP相关注解改造XML案例



#### 1. 注解改造XML案例

##### 1.1 改造工程

- 工程名称: spring-day03-anno

##### 1.2 改造通知

- LogAdvice.java

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



### 11总结

- 什么是代理模式?
  - 
- 动态代理JDK和CGLIB的区别?
  - 
  - 
- Spring AOP的底层是什么?
  - 
- 切面和切入点以及通知是什么?
  - 
- 通知类型有哪些?
  - 
  - 
  - 
  - 
  - 
- AOP相关的注解有哪些?
  - 
  - 
  - 
  - 
  - 

