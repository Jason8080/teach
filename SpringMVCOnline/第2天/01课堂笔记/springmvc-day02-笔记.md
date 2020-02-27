

### 10参数绑定-默认支持【了解】

#### 目标

- 了解默认支持的参数类型



#### 1. 默认支持的参数类型

- com.itheima.demo.ParamController

  ```java
  
  ```



#### 小结

- 支持哪些常用的ServletAPI?
  - 
- Model参数的作用是什么?
  - 



### 11自定义参数转换器【理解】

#### 目标

- 理解SpringMVC的参数转换器



#### 1. 自定义参数转换器

1. 定义转换器: com.itheima.demo.DateConverter

   ```java
   
   ```

2. 配置转换器: springMVC.xml

```xml
<!-- 1. 指定转换服务 -->
<mvc:annotation-driven conversion-service="conversionServiceFactoryBean" />

<!-- 2. 注册转换工厂 -->
<bean id="conversionServiceFactoryBean" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
	<property name="converters">
        <set>
            <bean class="com.itheima.demo.DateConverter"/>
        </set>
    </property>
</bean>
```



#### 小结

- 自定义的转换器需要实现什么接口?
  - 
- 自定义的转换器需要做什么配置?
  - 





### 12高级绑定-数组【了解】

#### 目标

- 了解数组类型参数的绑定



#### 1. 数组类型参数的绑定

1. 接收数组: com.itheima.demo.Param2Controller

  ```java
  
  ```

2. 提交数组: index.jsp

  ```jsp
  
  ```



#### 小结

- 在页面中如何表现为数组?
  - 



### 13高级绑定-集合【了解】

#### 目标

- 了解直接绑定的集合
- 了解嵌套绑定的集合



#### 1. 直接绑定的集合

1. 接收集合: com.itheima.demo.Param2Controller

  ```java
  // 注意: SpringMVC不支持直接绑定集合
  
  ```

2. 提交集合: index.jsp

  ```jsp
  <!-- 根据@RequestParam特点,参数名需要一致 -->
  
  ```



#### 2. 嵌套绑定的集合

1. 嵌套对象: com.itheima.demo.domain.Account

  ```java
  
  ```

2. 嵌套参数: com.itheima.demo.Param2Controller

  ```java
  
  ```

3. 提交参数: index.jsp

  ```jsp
  
  ```

  

#### 小结

- 直接绑定集合参数需要做什么?
  - 
- 嵌套集合如何传参给指定属性?
  - 
- 可否将接收到的参数返回给前端？
  - 





### 14返回值的用法【理解】

#### 目标

- 理解string的用法
- 理解mv的用法
- 理解void的用法



#### 1. string的用法

- com.itheima.demo.ReturnController

  ```java
  
  ```

#### 2. mv的用法

- com.itheima.demo.ReturnController

  ```java
  
  ```

#### 3. void的用法

- com.itheima.demo.ReturnController

  ```java
  
  ```



#### 小结

- 关键字forward:的作用?
  - 
- 返回值mv与string的关系?
  - 



### 15总结

1. 什么是SpringMVC?
   - 
2. 入门案例中的处理器是哪个类?
   - 
3. SpringMVC的三大组件是哪些?
   - 
   - 
   - 

4. `<mvc:annotation-driven/>`的作用?

   - 

5. SpringMVC的入口类是哪个?

   - 

6. @RequestMapping的作用?

   - 

7. 至少说出3个默认支持的参数类型?

   - 

   - 

   - 

8. SpringMVC支持哪些参数绑定?

   - 
   - 
   - 

9. Controller返回值有哪些类型?

   - 
   - 
   - 



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

3. 后端控制器: com.itheima.json.JsonController

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

2. 创建实体: com.itheima.json.domain.Account

    ```java
    
    ```

3. 使用注解: com.itheima.json.JsonController

    ```java
    
    ```

4. 页面请求: index.jsp

    ```html
    <h3>演示: json数据交互</h3>
    <form id="jsonForm">
        <input type="text" name="id" value="1" />
        <input type="text" name="uid" value="2" />
        <button type="button" onclick="jsonCommit()">提交</button>
        <div id="jsonRes"></div>
    </form>
    <script>
    	function jsonCommit() {
            // 1. 创建异步请求对象
            var req = new XMLHttpRequest();
            // 2. 打开请求
            req.open("POST", "json", true);
            // 3. 设置请求的数据类型(必须)
            req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            // 4. 异步读取响应
            req.onreadystatechange = function () {
                // 2.1 判断响应状态
                if (req.readyState == 4 || req.status == 200) {
                    var data = req.responseText;
                    document.getElementById("jsonRes").innerHTML = data;
                }
            };
            // 5. 封装数据
            var es =
                document.getElementById("jsonForm").getElementsByTagName("input");
            var json = {};
            for (var i = 0; i <= es.length; i++) {
                if (es[i] != undefined) {
                    var name = es[i].name;
                    var value = es[i].value;
                    json[name] = value;
                }
            }
            // 6. 发送数据
            var body = JSON.stringify(json);
            req.send(body);
        }
    </script>
    ```



#### 小结

- 如何使用对象接收json数据?
  - 
- 响应对象如何转换成json数据?
  - 



### 03RESTful风格【了解】

#### 目标

- RESTful的简介
- RESTful的特点



#### 1. RESTful的简介

- REST(presentational State Transfer)是**URL编码规范**
- RESTful本身并不是技术, 组件或服务
- 以下是传统URL编码风格与RESTful的对比

  |             | 增        | 删                   | 改                   | 查                |
  | ----------- | --------- | -------------------- | -------------------- | ----------------- |
  | 传统        | /user/add | /user/delete?id={id} | /user/update?id={id} | /user/get?id={id} |
  | **RESTful** | /user     | /user/{id}           | /user/{id}           | /user/{id}        |

- 【先】提供方法: com.itheima.json.RestController

  ```java
  
  ```

  

#### 2. RESTful的特点

##### 2.1 接口唯一

> ​	每个资源都有一个唯一的 **URL**

1. com.itheima.json.RestController

   ```java
   // 使用@PathVariable映射URL中的参数
   ```



##### 2.2 接口统一

> ​	同类资源的各种操作只需一个URL, 各种操作以 **Method** 区分

1. web.xml

   ```xml
   <!-- 配置HiddenHttpMethodFilter支持 -->
   ```

2. com.itheima.json.RestController

   ```java
   // 注意: 浏览器不支持的方法只能返回Json数据
   ```

3. index.jsp

   ```jsp
   
   ```



#### 小结

- RESTful的特点有哪些?
  - 
  - 
- @PathVariable的作用?
  - 
- HiddenHttpMethodFilter的作用?
  - 

