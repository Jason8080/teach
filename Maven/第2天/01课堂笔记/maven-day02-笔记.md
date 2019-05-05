#### 01复习【理解】

##### 目标

- 回顾maven第1天的内容
- 加深mavne的理解

##### 步骤

###### Mvn的概念

- [Apache Maven](http://maven.apache.org/) 是一种创新的软件项目管理工具。
- 提供了一个项目对象模型（POM）文件的新概念来管理项 目的构建，相关性和文档。
- 最强大的功能就是能够自动下载项目 **jar包** 。 

###### 有哪些特点

- 跨平台: 基于 Java 平台的项目构建
- 自动化: 自动下载依赖 
- 标准化: 项目结构统一标准 
- 可重用: POM可重用设计 ( **继承/聚合** )

###### 仓库是什么

- 生活常见的仓库有 **粮仓, 米仓** ;
- 存放的是生活所需品 - **粮食**。
- 

###### 坐标是什么

- 仓库中的jar包像地球上海量的建筑。
- 

###### 依赖是什么

- 依赖是对仓库中jar包的引用配置
- 必须信息是坐标
- scope可以指定引用范围, 默认是compile。

| 依赖范围 | 说明     | 编译是否有效 | 测试是否有效 | 运行是否有效 | 是否打包 | 实际应用    |
| -------- | -------- | ------------ | ------------ | ------------ | -------- | ----------- |
| compile  | 编译范围 | √            | √            | √            | √        | ssm         |
| test     | 测试范围 | √            | √            | ×            | ×        | junit       |
| provided | 容器范围 | √            | √            | ×            | ×        | servlet-api |
| runtime  | 运行范围 | ×            | √            | √            | √        | jdbc驱动    |



##### 操作

###### 下载MVN

- [Maven3](http://archive.apache.org/dist/maven/maven-3/)

###### 创建项目

- 项目名称: maven-day02-parent

###### 依赖Junit

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```



##### 小结

- groupId,artifactId,version是什么?

  - 

- scope范围有哪些可选项?

  - 

  

#### 02使用idea【了解】

##### 目标

- 在idea开发工具上使用maven管理项目

##### 步骤

###### 为什么使用idea

- 手工操作较多，编译、测试、部署等工作都是独立的，很难一步完成。
- 每个人的 IDE 配置都不同，很容易出 现本地代码换个地方编译就报错。 

###### idea配置

- File > Settings > Build, Execution, Deployment > Build Tools > Maven
- **Maven home directory** : 安装目录
- **User settings file** : C:\Users\Administrator.m2\settings.xml
- **Local repository** : 本地仓库路径 

##### 操作

…

##### 小结

- 为什么在C:\Users\Administrator.m2目录下放置settings.xml文件
  - 



#### 03依赖传递【掌握】

##### 目标

- 理解依赖的可传递特性

##### 步骤

###### 依赖传递案例

- 使用Spring框架时只需要依赖spring-context，即可完成spring的IOC容器的使用;
-  

###### 依赖传递选项

- 可以使用optional标签控制当前的依赖是否向下传递; 
- 

###### 依赖传递冲突

![1556527769408](assets/1556527769408.png) 

```xml
<!-- A项目依赖 -->
<dependencies>
    <dependency>
        <groupId>test</groupId>
        <artifactId>B</artifactId>
        <version>1.0</version>
	</dependency>
    <dependency>
        <groupId>test</groupId>
        <artifactId>D</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

- 短路优先
  -  
- 解决冲突
  - 

##### 操作

###### 解决冲突

```xml

```



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



#### 01复习【理解】

##### 目标

- 

##### 步骤



##### 操作



##### 小结

- 



