### 01复习

#### 目标

- 了解常见的面试题



#### 1. 了解常见的面试题

##### 1.1 IOC的底层/原理是什么

- IOC的底层/原理是工厂设计模式
- 是将对象创建转交给工厂来完成的(控制反转)
- IOC在工厂中维护了Map集合存储对象, 可以重复使用



##### 1.2 Spring的Bean都是单例的吗

- 默认都是单例的
- 可以设置为多例模式
- 单例对象会存储到IOC容器中, 多例对象不会
- 单例对象默认是在容器启动时创建, 而多例是使用时创建的



##### 1.3 工厂设计模式有什么好处

- 代码解耦: 不用关心对象创建的过程
- 消除重复: 创建对象的过程可以重复使用



#### 小结

- IOC创建对象的注解有哪些?
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

1. 工程名称: 01_spring_day03_proxy

2. 添加依赖: pom.xml

    ```xml
    
    ```

3. 定义明星接口: com.itheima.proxy.Star

    ```java
    
    ```

4. 创建目标类: com.itheima.proxy.LiuStar

    ```java
    
    ```

5. 创建代理类: com.itheima.proxy.LiuStarProxy

    ```java
    
    ```
    
6. 单元测试: LiuStarProxyTests.java

    ```java
    // 【静态代理的特点】
    // 1. 代理对象需要在代码运行前创建
    // 2. 需要在内部维护一个目标对象
    // 3. 需要实现与目标对象相同的接口
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
  
  > 常见的动态代理有jdk,cglib两种



#### 2. jdk动态代理案例

1. 官网API (Proxy)

    ```java
    public static Object newProxyInstance(
       						// 1. 类加载器
                            ClassLoader loader,
        					// 2. 代理对象需要实现的接口数组
                            Class<?>[] interfaces,
        					// 3. 代理对象方法调用时的处理器
                            InvocationHandler h
    ) throws IllegalArgumentException
    ```

2. 单元测试: LiuStarProxyTests.java

    ```java
    // 1. 创建目标对象
    
    // 2. 创建代理对象
    
    // 3. 使用代理对象
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

1. 官网API (Enhancer)

    ```java
    public static Object create(
        					// 1. 代理对象需要继承的类
                            java.lang.Class superclass,
    						// 2. 代理对象需要实现的接口
                            java.lang.Class[] interfaces,
    						// 3. 代理对象方法调用时的处理器 InvocationHandler
                            Callback[] callbacks
    )
    ```

2. 单元测试: LiuStarProxyTests.java

    ```java
    
    ```



#### 2. 两种动态代理的区别

|          | JDK                                           | CGLIB                                    |
| -------- | --------------------------------------------- | ---------------------------------------- |
| 实现方式 | 利用 **实现** 接口方法来拦截目标方法          | 利用 **继承** 覆写方法来拦截目标方法     |
| 性能高低 | JDK1.6以前较Cglib慢; 1.6以及1.7大量调用时较慢 | 1.8时被JDK代理超越                       |
| 适用场景 | 目标对象必须实现接口                          | 目标方法需要允许覆写(不能用final/static) |



#### 小结

- 常见的动态代理有哪些?
  - 

- 两种动态代理有什么区别?
  - 
  - 



### 05AOP的概念【理解】

#### 目标

- 理解AOP相关的概念
- 理解AOP相关的术语



#### 1. 相关的概念

##### 1.1 AOP的概念

- AOP (Aspect Oriented Programming) 即面向切面编程思想

##### 1.2 AOP的作用

- 在不修改目标对象的情况下对业务进行 **增强 **(其他处理)

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
- 请描述下列术语的含义:
  - 连接点: 
  - 切入点: 
  - 通知: 
  - 切面: 



### 06AOP的XML案例【掌握】

#### 目标

- 使用AOP自动记录日志
- 掌握AOP动态代理细节



#### 1. AOP自动记录日志

1. 工程名称: 02_spring_day03_xml

2. 添加依赖: pom.xml

    ```xml
    <!-- 1. 添加Spring IOC和AOP依赖 -->
    
    <!-- 2. 添加AspectJ(第三方框架: 支持AOP切入点表达式语法)依赖 -->
    
    <!-- 3. 添加SpringTest依赖 -->
    ```

3. 业务处理: com.itheima.xml.impl.AccountServiceImpl

    ```java
    
    ```
    
4. 记录日志: com.itheima.xml.advice.LogAdvice

    ```java
    
    ```

5. 配置AOP: applicationContext.xml

    ```xml
    
    ```

6. 单元测试: XmlTests

    ```java
    
    ```



#### 2. AOP动态代理细节

##### 2.1 动态代理的类型

1. 打印代理对象字节码: XmlTests

    ```java
    
    ```

2. 实现类实现接口: com.itheima.xml.AccountService

    ```java
    // 1. 再次打印代理对象字节码: 观察代理类型的变化
    ```

##### 2.2 动态代理的配置

- 指定代理类型: applicationContext.xml

    ```xml
<!-- 
    	<aop:config: 配置AOP
    		proxy-target-class: 配置是否强制使用cglib动态代理
    -->
    <aop:config proxy-target-class="true">
    ```



#### 小结

- 自动记录日志的原理是什么?
  - 

- 两种动态代理Spring是如何选择的?
  - 



### 07切入点表达式【理解】

#### 目标

- 理解什么是切入点表达式
- 了解切入点表达式指示符



#### 1. 什么是切入点表达式

- 定位切入点的1种语法规则



#### 2. 切入点表达式指示符

- 切入点表达式常见的 指示符 (PCD)有以下三种

| 指示符        | 示例                                                    | 作用(细粒度)        |
| ------------- | ------------------------------------------------------- | ------------------- |
| bean          | bean(accountService)                                    | 精确到IOC容器的bean |
| within        | within(com.itheima.xml.service.impl.AccountServiceImpl) | 精确到类            |
| **execution** | execution(public void com.itheima..save(..))            | **精确到方法**      |

##### 2.1 bean

1. pointcut.xml

    ```xml
    
    ```

##### 2.2 within

1. pointcut.xml

    ```xml
    
    ```

##### 2.3 execution

1. pointcut.xml

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

1. 通知类型分类: 前置通知、后置通知、异常通知、最终通知
2. 提供通知方法: com.itheima.xml.advice.LogAdvice

    ```java
    
    ```

3. 配置通知类型: advice.xml

    ```xml
    
    ```



#### 小结

- 通知分为哪几类?
  - 



### 09AOP的环绕通知【掌握】

#### 目标

- 掌握通用通知的使用
- 掌握环绕通知的优点



#### 1. 环绕通知

1. com.itheima.xml.advice.LogAdvice

    ```java

    ```

1. advice.xml

   ```xml
   
   ```

   

#### 小结

- 环绕通知的优点?
  - 



### 10AOP的注解案例【理解】

#### 目标

- 使用AOP相关注解改造XML案例



#### 1. 注解改造XML案例

##### 1.1 改造工程

- 工程名称: 03_spring_day03_anno

##### 1.2 改造通知

- com.itheima.xml.advice.LogAdvice

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

1. 什么是代理模式?
  - 
2. 动态代理JDK和CGLIB的区别?
  - 
  - 
3. Spring AOP的底层是什么?
  - 
4. 切面和切入点以及通知是什么?
  - 
5. 通知类型有哪些?
  - 
  - 
  - 
  - 
  - 
6. AOP相关的注解有哪些?
  - 
  - 
  - 
  - 
  - 

