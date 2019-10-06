### 01复习

#### 目标

- 搭建SpringMVC案例环境



#### 1. 搭建案例环境

##### 1.1 环境搭建

- 工程名称: mvc02_controller_01
- 添加WEB: 转换为WEB工程
- 添加依赖: pom.xml

```xml

```



##### 1.2 配置组件

- 前端控制器: web.xml

```xml

```

- 三大组件: springMVC.xml

```xml

```

- 后端控制器: com.itheima.controller.ParamController

```java

```



##### 1.3 单元测试

- pages/success.jsp

```jsp

```

- index.jsp

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



### 02高级绑定-数组【了解】

#### 目标

- 了解数组类型参数的绑定



#### 1. 数组类型参数的绑定

- 接收数组: com.itheima.controller.ParamController

    ```java

    ```

- 提交数组: index.jsp

    ```jsp

    ```



#### 小结

- 在页面中如何表现为数组?
  - 



### 03高级绑定-集合【了解】

#### 目标

- 了解直接绑定的集合
- 了解嵌套绑定的集合



#### 1. 直接绑定的集合

- 接收集合: com.itheima.controller.ParamController

    ```java
    // 注意: SpringMVC不支持直接绑定集合

    ```

- 提交集合: index.jsp

    ```jsp
    <!-- 根据@RequestParam特点,参数名需要一致 -->

    ```



#### 2. 嵌套绑定的集合

- 嵌套参数: com.itheima.controller.ParamController

  ```java
  
  ```

- 嵌套对象: com.itheima.controller.Account

  ```java
  
  ```

- 提交参数: index.jsp

  ```jsp
  
  ```

  

#### 小结

- 直接绑定集合参数需要做什么?
  - 
- 嵌套集合如何传参给指定属性?
  - 



### 04返回值-void【理解】

#### 目标

- 理解返回值void的3个用法

#### 1. 返回值void的3个用法

##### 1.1 转发

- com.itheima.controller.ReturnController

    ```java

    ```

##### 1.2 重定向

- com.itheima.controller.ReturnController

    ```java

    ```

##### 1.3 响应数据

- com.itheima.controller.ReturnController

    ```java

    ```



#### 小结

- 为什么可以不返回视图呢?
  - 



### 05返回值-string【掌握】

#### 目标

- 理解返回值string的用法



#### 1. 返回值string的用法

##### 1.1 转发

- com.itheima.controller.ReturnController

    ```java

    ```

##### 1.2 重定向

- com.itheima.controller.ReturnController

    ```java

    ```

##### 1.3 响应数据

- com.itheima.controller.ReturnController

    ```java
    // 需要配合Model使用

    ```



#### 小结

- 使用forward:的作用?
  - 



### 06返回值-MV【理解】

#### 目标

- 理解返回值ModelAndView的用法



#### 1. 返回值ModelAndView的用法

- com.itheima.controller.ReturnController

    ```java

    ```



#### 小结

- 返回值mv与string的区别?
  - 



### 07数据交互-json【掌握】

#### 目标

- 掌握json格式的数据交互



#### 1. json格式的数据交互

- 添加依赖: pom.xml

    ```xml
    <!-- SpringMVC默认采用jackson进行json数据处理 -->

    ```

- com.itheima.controller.JsonController

    ```java

    ```

- index.jsp

    ```jsp

    ```

- Function commit

    ```js

    ```



#### 小结

- 使用jackson转换对象需要添加什么注解?
  - 
- 响应对象如何转换成json数据?
  - 



### 08RESTful风格【了解】

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

- com.itheima.controller.RestController

    ```java
    // 使用@PathVariable映射URL中的参数

    ```



#### 小结

- RESTful是什么?
  - 
- @PathVariable的作用?
  - 



### 09RESTful支持【了解】

#### 目标

- 了解RESTful的方法支持



#### 1. RESTful的方法支持

- web.xml

    ```xml
    <!-- 浏览器不支持GET/POST之外的HTTP方法, 需要配置SpringMVC支持 -->

    <!-- SpringMVC使用HiddenHttpMethodFilter将隐藏域解析为提交方法 -->
    ```

- com.itheima.controller.RestController

    ```java
// 注意: 浏览器不支持的方法只能返回Json数据
    ```

- index.jsp

    ```jsp

    ```



#### 小结

- HiddenHttpMethodFilter的作用?
  - 



### 10文件上传-传统【了解】

#### 目标

- 回顾传统的文件上传



#### 1. 传统的文件上传

- 添加依赖: pom.xml

    ```xml
    <!-- 基于commons-fileupload组件完成文件解析 -->

    ```

- com.itheima.controller.UploadController

    ```java
    // 1. 指定上传目录

    // 2. 创建组件工具

    // 3. 解析请求数据

    // 4. 处理数据(包括普通字段和文件字段)
    ```



#### 小结

- 传统方式需要解析文件吗?
  - 



### 11SpringMVC上传【了解】

#### 目标

- 使用SpringMVC上传文件



#### 1. SpringMVC上传文件

- springMVC.xml

    ```xml
    <!-- 注册多媒体(文件)解析器: CommonsMultipartResolver --> 

    ```

- com.itheima.controller.UploadController

    ```java

    ```



#### 小结

- multipartResolver的作用是什么?
  - 



### 12总结

- SpringMVC支持哪些参数绑定?
  - 
  - 
  - 
- Controller返回值有哪些类型?
  - 
  - 
  - 
- @RequestBody的作用?
  - 
- @ResponseBody的作用?
  - 
- @PathVariable的作用?
  - 
- 为什么配置multipartResolver?
  - 