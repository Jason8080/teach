### 01复习

#### 目标

- 搭建SpringMVC案例环境



#### 1. 搭建案例环境

##### 1.1 环境搭建

1. 工程名称: mvc02_json_01

2. 添加WEB: 转换为WEB工程

3. 添加依赖: pom.xml

   ```xml
   
   ```



##### 1.2 配置组件

1. 前端控制器: web.xml

   ```xml
   
   ```

2. 三大组件: springMVC.xml

   ```xml
   
   ```

3. 后端控制器: com.itheima.json.ParamController

   ```java
   
   ```



##### 1.3 单元测试

1. pages/success.jsp

   ```jsp
   
   ```

2. index.jsp

   ```jsp
   
   ```



#### 小结

- SpringMVC的三大组件是?
  - 
  - 
  - 
- SpringMVC的工作流程是?
  - 
- 控制器支持哪些参数绑定?
  - 



### 02数据交互-json【掌握】

#### 目标

- 掌握json格式的数据交互



#### 1. json格式的数据交互

1. 添加依赖: pom.xml

    ```xml
    <!-- SpringMVC默认采用jackson进行json数据处理 -->
    
    ```

2. com.itheima.json.JsonController

    ```java
    
    ```

3. index.jsp

    ```jsp
    
    ```

4. Function commit

    ```js
    function jsonCommit() {
        // 1. 创建异步请求对象
        let req = new XMLHttpRequest();
        // 2. 打开请求
        req.open("POST", "json", true);
        // 3. 设置请求的数据类型(必须)
        req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        // 4. 异步读取响应
        req.onreadystatechange = function () {
            // 2.1 判断响应状态
            if (req.readyState == 4 || req.status == 200) {
                let data = req.responseText;
                document.getElementById("jsonRes").innerHTML = data;
            }
        };
        // 5. 封装数据
        let es =
            document.getElementById("jsonForm").getElementsByTagName("input");
        let json = {};
        for (let i = 0; i <= es.length; i++) {
            if (es[i] != undefined) {
                let name = es[i].name;
                let value = es[i].value;
                json[name] = value;
            }
        }
        // 6. 发送数据
        let body = JSON.stringify(json);
        req.send(body);
    }
    ```



#### 小结

- 如何使用对象接收json数据?
  - 
- 响应对象如何转换成json数据?
  - 



### 03RESTful风格【了解】

#### 目标

- 了解RESTful风格
- RESTful参数绑定



#### 1. RESTful介绍

##### 1.1 基本概诉

- REST全称是Representational State Transfer，REST本身并没有创造新的技术、组件或服务。
- REST指的是约束条件和原则，如果一个架构符合REST的约束条件和原则，就称它为RESTful架构。

##### 1.2 风格对比

|             | 增        | 删                | 查             | 改                |
| ----------- | --------- | ----------------- | -------------- | ----------------- |
| 传统        | /user/add | /user/delete?id=1 | /user/get?id=1 | /user/update?id=1 |
| **RESTful** | /user     | /user/1           | /user/1        | /user/1           |

#### 2. RESTful参数

- com.itheima.json.RestController

    ```java
    // 使用@PathVariable映射URL中的参数

    ```



#### 小结

- RESTful是什么?
  - 
- @PathVariable的作用?
  - 



### 04RESTful支持【了解】

#### 目标

- 了解RESTful的方法支持



#### 1. RESTful的方法支持

1. web.xml

    ```xml
    <!-- 浏览器不支持GET/POST之外的HTTP方法, 需要配置SpringMVC支持 -->
    
    <!-- SpringMVC使用HiddenHttpMethodFilter将隐藏域解析为提交方法 -->
    ```

2. com.itheima.json.RestController

    ```java
    // 注意: 浏览器不支持的方法只能返回Json数据
    ```

3. index.jsp

    ```jsp
    
    ```



#### 小结

- HiddenHttpMethodFilter的作用?
  - 



### 05文件上传-传统【了解】

#### 目标

- 回顾传统的文件上传



#### 1. 传统的文件上传

1. 添加依赖: pom.xml

    ```xml
    <!-- 基于commons-fileupload组件完成文件解析 -->
    
    ```

2. 前端页面: pages/index.jsp

    ```jsp
    
    ```

3. com.itheima.json.UploadController

    ```java
    // 1. 获取上传目录
    
    // 2. 创建Servlet文件上传工具
    
    // 3. 解析请求
    
    // 4. 遍历参数字段
    
    // 5. 响应资源
    ```



#### 小结

- 传统方式需要解析文件吗?
  - 



### 05SpringMVC上传【了解】

#### 目标

- 使用SpringMVC上传文件



#### 1. SpringMVC上传文件

1. springMVC.xml

    ```xml
    <!-- 注册多媒体(文件)解析器: CommonsMultipartResolver --> 
    
    ```

2. com.itheima.json.UploadController

    ```java
    // 1. 获取上传目录
    
    // 2. 转移到( 磁盘文件 )
    ```



#### 小结

- multipartResolver的作用是什么?
  - 



### 07异常处理方案【理解】

#### 目标

- 分析3层架构中代码的调用关系
- 分析3层架构中异常的处理方案



#### 1. 代码调用关系

##### 1.1  三层架构案例

1. 工程名称: mvc02_ex_02

2. 升级工程: 转换为WEB工程

3. 添加依赖: pom.xml

   ```xml
   <!-- 1. 设置打包类型 -->
   
   <!-- 2. 添加依赖 -->
       <!-- SpringMVC 依赖 --> 
       <!-- Servlet 依赖 -->
       <!-- Jsp 依赖 -->
       <!-- Jstl 依赖 -->
   ```

4. 配置项目: web.xml

   ```xml
   <!-- 1. 配置资源路径【/】 -->
   
   <!-- 2. 配置前端控制器 -->
   ```

5. 添加配置: springMVC.xml

   ```xml
   <!-- 1. 扫描Spring组件注解【com.itheima.ex】 -->
   
   <!-- 2. 注册三大组件 -->
   ```

6. com.itheima.ex.UserController

   ```java
   
   ```

7. 添加页面: pages/

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

##### 1.2 代码调用关系

![1567403737180](assets/1567403737180.png)



#### 2. 异常处理方案

##### 2.1 代码处理

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

##### 2.2 过滤器处理

1. 创建过滤器: com.itheima.ex.filter.ExceptionFilter

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
              .getRequestDispatcher("/pages/error.jsp");
          request.setAttribute("msg", e.getMessage());
          rd.forward(request, response);
      }
  }
  ```

2. 配置过滤器: web.xml

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

- 欲知框架如何, 请看下回分解 !



#### 小结

- 3层架构中的代码调用关系？
  - 
- 代码捕捉方式有什么缺点?
  - 



### 08统一异常处理【掌握】

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



### 09自定义拦截器【理解】

#### 目标

- 自定义SpringMVC拦截器
- 拦截器与过滤器的区别



#### 1.  自定义拦截器

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



### 10总结

1. 使用Json交互需要什么依赖?
   - 
2. @RequestBody的作用?
   - 
3. @ResponseBody的作用?
   - 
4. @PathVariable的作用?
   - 
5. 为什么配置multipartResolver?
   - 
6. 如何对SSM项目做统一异常处理?
   - 
7. 过滤器与拦截器的区别是什么?
   - 