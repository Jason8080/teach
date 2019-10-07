### 01复习

#### 目标

- 搭建SpringMVC项目环境
- 三层架构的代码调用关系



#### 1. 搭建项目环境

1. 工程名称: mvc03_ex_01

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. 设置打包类型 -->
   
   <!-- 2. 添加依赖 -->
       <!-- SpringMVC 依赖 --> 
       <!-- Servlet 依赖 -->
       <!-- Jsp 依赖 -->
       <!-- Jstl 依赖 -->
   ```

3. 配置项目: web.xml

   ```xml
   <!-- 1. 配置资源路径【/】 -->
   
   <!-- 2. 配置前端控制器 -->
   ```

4. 添加配置: springMVC.xml

   ```xml
   <!-- 1. 扫描Spring组件注解【com.itheima.ex】 -->
   
   <!-- 2. 注册三大组件 -->
   ```

5. com.itheima.ex.controller.UserController

   ```java
   
   ```

6. WEB-INF/jsp/

   - success.jsp

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>OK</title>
     </head>
     <body>
         操作成功 !
     </body>
     </html>
     ```

   - error.jsp

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>Fail</title>
     </head>
     <body>
         操作失败 !${msg}
     </body>
     </html>
     ```



#### 2. 代码调用关系

![1567403737180](assets/1567403737180.png) 



#### 小结

- 3层架构中代码的调用关系是怎样的?
  - 
- 如果代码中出现异常应在哪1层处理?
  - 



### 02异常处理方案【理解】

#### 目标

- 分析3层架构中异常的处理方案



#### 1. 异常处理方案

##### 1.1 代码处理

```java
@RequestMapping("list")
public String list(Model model) {
    try {
        int i = 1 / 0;
        // service.method();
    } catch (Exception e) {
        model.addAttribute("msg", e.getMessage());
        return "error";
    }
    return "success";
}
```

##### 1.2 过滤器处理

- 创建过滤器: com.itheima.ex.filter.ExceptionFilter

  ```java
  @Override
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain) throws ServletException, IOException {
      try {
          // 放行: 交给下一个过滤器或者Servlet处理
          chain.doFilter(request, response);
      } catch (Exception e) {
          RequestDispatcher rd = request
              .getRequestDispatcher("/WEB-INF/jsp/error.jsp");
          request.setAttribute("msg", e.getMessage());
          rd.forward(request, response);
      }
  }
  ```

- 配置过滤器: web.xml

  ```xml
  <filter>
      <filter-name>ex</filter-name>
      <filter-class>com.itheima.ex.filter.ExceptionFilter</filter-class>
  </filter>
  <filter-mapping>
      <filter-name>ex</filter-name>
      <url-pattern>/*</url-pattern>
  </filter-mapping>
  ```

##### 1.3 框架处理

- 欲知后事如何, 请看下节分解 !



#### 小结

- 代码捕捉方式有什么缺点?
  - 



### 03统一异常处理【掌握】

#### 目标

- SpringMVC的异常源码分析
- SpringMVC的统一异常处理



#### 1. 框架处理分析

- 【源码】org.springframework.web.servlet.DispatcherServlet

  ```java
  private void processDispatchResult(HttpServletRequest request, HttpServletResponse response, @Nullable HandlerExecutionChain mappedHandler, @Nullable ModelAndView mv, @Nullable Exception exception) throws Exception {
      boolean errorView = false;
      if (exception != null) {
          if (exception instanceof ModelAndViewDefiningException) {
              this.logger.debug("ModelAndViewDefiningException encountered", exception);
              mv = ((ModelAndViewDefiningException)exception).getModelAndView();
          } else {
              Object handler = mappedHandler != null ? mappedHandler.getHandler() : null;
              // 异常处理方法【执行出现异常将获取异常解析器处理异常】
              mv = this.processHandlerException(request, response, handler, exception);
              errorView = mv != null;
          }
      }
  
      if (mv != null && !mv.wasCleared()) {
          this.render(mv, request, response);
          if (errorView) {
              WebUtils.clearErrorRequestAttributes(request);
          }
      } else if (this.logger.isTraceEnabled()) {
          this.logger.trace("No view rendering, null ModelAndView returned.");
      }
  
      if (!WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted()) {
          if (mappedHandler != null) {
              mappedHandler.triggerAfterCompletion(request, response, (Exception)null);
          }
  
      }
  }
  ```

- 【源码】org.springframework.web.servlet.HandlerExceptionResolver

  ```java
  @Nullable
  ModelAndView resolveException(HttpServletRequest var1, HttpServletResponse var2, @Nullable Object var3, Exception var4);
  ```

#### 2. 统一异常处理

- 创建异常处理器: com.itheima.ex.ExceptionHandler

  ```java
  
  ```



#### 小结

- 定义多个异常处理类都会生效吗?
  - 
- SpringMVC异常处理的底层原理?
  - 



### 04自定义拦截器【理解】

#### 目标

- 理解SpringMVC拦截器
- 拦截器与过滤器的区别



#### 1.  SpringMVC拦截器

##### 1.1 拦截什么资源

- 

##### 1.2 拦截器的作用

- 

##### 1.3 自定义拦截器

1. 创建拦截器: com.itheima.ex.interceptor.CustomInterceptor

   ```java
   
   ```

2. 配置拦截器: springMVC.xml

   ```xml
   
   ```



#### 2. 拦截器与过滤器

| 组件名称 | 组件来源       | 应用范围              |
| -------- | -------------- | --------------------- |
| 拦截器   | SpringMVC      | Controller方法        |
| 过滤器   | Servlet2.3规范 | 所有WEB资源 ( **/** ) |



#### 小结

- 拦截器与过滤器的区别?
  - 



### 05SSM - 框架整合【掌握】

#### 目标

- 了解整合目的
- 整合步骤分析



#### 1. 了解整合目的

- 为什么要整合?

  >  在3层架构项目中, 各层都需要响应的解决方案, 所以SSM需要配合使用。

  - Spring: 
  - SpringMVC: 
  - Myabtis: 

#### 2. 整合步骤分析

- 在3层架构中, 哪些对象需要创建?
  - 
- 在3层架构中, 哪层需要Spring框架?
  - 

1. 使Spring环境正常运行
2. 使SpringMVC正常运行
3. 使Spring+SpringMVC共同运行
   - 
4. 使Mybatis正常运行
5. 使SSM共同运行
   - 
   - 
6. 整体测试





#### 小结

- 什么是SSM框架?
  - 
- 什么框架贯穿3层架构?
  - 



### 06SSM - 环境准备【理解】

#### 目标

- 准备数据环境
- 准备项目环境



#### 1. 准备数据环境

1. 数据库: mybatisdb

2. 表名称: account

   ```sql
   DROP TABLE IF EXISTS `account`;
   CREATE TABLE `account` (
     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `uid` int(11) DEFAULT '1' COMMENT '用户编号',
     `money` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
     PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;
   
   -- ----------------------------
   -- Records of account
   -- ----------------------------
   INSERT INTO `account` VALUES ('1', '1', '10.00');
   INSERT INTO `account` VALUES ('2', '10', '0.00');
   INSERT INTO `account` VALUES ('3', '24', '99.00');
   ```

#### 2. 准备项目环境

1. 工程名称: mvc03_ssm_02

2. 添加依赖: pom.xml

   ```xml
   <!-- 1. 添加Spring依赖 -->
   <!-- 2. 添加SpringMVC依赖 -->
   <!-- 4. 添加Mybatis依赖 -->
   <!-- 5. 添加测试依赖 -->
   <!-- 6. 添加日志依赖 -->
   <!-- 7. 添加页面依赖 -->
   ```

3. 实体类: com.itheima.ssm.domain.Account

   ```java
   
   ```

4. 数据库配置: db.properties

5. 日志配置: log4j.properties



#### 小结

- 非必需的依赖有哪些?
  - 



### 07SSM - Spring【理解】

#### 目标

- 搭建Spring独立环境



#### 1. 搭建Spring独立环境

1. 业务类: com.itheima.ssm.service.AccountService

   ```java
   
   ```

2. applicationContext.xml

   ```xml
   <!-- 1. Spring组件注解扫描 -->
   <!-- 2. 开启事务注解扫描 -->
   <!-- 3. 注册事务管理器【包括数据源】 -->
   ```

3. 单元测试: SsmTests

   ```java
   
   ```

   

#### 小结

- @RunWith的作用是什么?
  - 



### 08SSM - SpringMVC【理解】

#### 目标

- 搭建SpringMVC独立环境



#### 1. 搭建SpringMVC环境

1. 升级工程: war

2. 控制器: com.itheima.ssm.controller.AccountController

   ```java
   
   ```

3. springMVC.xml

   ```xml
   <!-- 1. Spring组件注解扫描 -->
   <!-- 2. 注册三大组件 -->
   ```

4. web.xml

   ```xml
   <!-- 1. 配置资源处理路径 -->
   <!-- 2. 配置处理器(前端控制器) -->
   ```

5. 添加页面

   - WEB-INF/jsp/accoun/list.jsp

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>账户列表</title>
     </head>
     <body>
         <h3>账户列表</h3>
         ${list}
     </body>
     </html>
     ```

   - WEB-INF/jsp/accoun/add.jsp

     ```jsp
     <%@ page contentType="text/html;charset=UTF-8" language="java" %>
     <html>
     <head>
         <title>账户注册</title>
     </head>
     <body>
         <h3>账户注册</h3>
         ...
     </body>
     </html>
     ```

6. 单元测试: http://localhost:8080/list



#### 小结

- MVC容器是谁启动的?
  - 



### 09SSM - 整合SS【理解】

#### 目标

- 整合Spring+SpringMVC框架



#### 1. 整合SS框架

​	![1567420138244](assets/1567420138244.png) 

1. 启动 **IOC** 容器: web.xml

   ```xml

   ```
   
2. 注入业务对象: com.itheima.ssm.controller.AccountController

   ```java
   
   ```

   



#### 小结

- ContextLoaderListener的作用?
  - 

- 父子容器启动的顺序是怎样的?
  - 



### 10SSM - Mybatis【理解】

#### 目标

- 搭建Mybatis独立环境



#### 1. 搭建Mybatis环境

1. 持久类: com.itheima.ssm.dao.AccountDao

   ```java
   
   ```

2. sqlMapConfig.xml

   ```xml
   <!-- 1. 引入数据库配置文件 -->
   
   <!-- 2. 配置Mybatis环境 -->
   
   <!-- 3. 配置Mybatis映射器 -->
   ```

3. 单元测试: SsmTests

   ```java
   // 1. 加载配置文件
   // 2. 创建会话工厂对象
   // 3. 创建会话对象
   // 4. 创建映射器代理对象
   // 5. 操作数据库
   // 6. 提交事务
   // 7. 关闭资源
   ```



#### 小结

- 启动Mybatis框架需要做什么?
  - 
  - 



### 11SSM - 整合SM【理解】

#### 目标

- 整合Spring+Mybatis框架



#### 1. 整合SM框架

> ​	启动Mybatis框架只需要做两件事
>
> 1. 创建会话工厂
> 2. 创建代理对象

1. applicationContext.xml: 创建会话工厂

   ```xml
   <!-- 1. 注入数据源 -->
   <!-- 2. 赋值configLocation: classpath:sqlMapConfig.xml -->
   ```

2. applicationContext.xml: 创建代理对象

   ```xml
   <!-- 1. 根据指定包下的接口创建动态代理对象 (映射器对象: 创建之后会放到IOC容器中) -->
   ```

3. 注入持久对象: com.itheima.ssm.service.AccountService

   ```java
   
   ```



#### 小结

- Mybatis是谁启动的?
  - 



### 12SSM - 整体测试【了解】

#### 目标

- 改造前后端代码进行整体测试



#### 1. 项目改造

1. WEB-INF/jsp/accoun/list.jsp

   ```jsp
   
   ```

2. WEB-INF/jsp/accoun/add.jsp

   ```jsp
   
   ```



#### 小结

- mybatis-spring依赖的作用?
  
  - 



### 13总结

1. 如何对SSM项目做统一异常处理?
   - 
2. 过滤器与拦截器的区别是什么?
   - 
3. 什么是SSM ?
   - 
4. 整合Spring+SpringMVC需要额外添加依赖吗?
   - 
5. 整合Spring+Mybatis需要额外添加依赖吗?
   - 
6. SpringMVC的三大组件有哪些?
   - 
   - 
   - 
7. SpringMVC的工作原理?
   1. 