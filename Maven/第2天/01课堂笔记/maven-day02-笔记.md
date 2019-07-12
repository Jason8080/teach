### 01复习【理解】

#### 目标

- Maven是什么

- Maven相关概念

- Maven的使用

  

#### 1. Maven是什么

- [Apache Maven](http://maven.apache.org/) 是一种 **项目管理工具**
- 通过将项目信息 封装成 **pom.xml** (项目对象模型)
- 最强大的功能就是能够 **自动下载jar包** 



#### 2. Maven相关概念

- 仓库
  
  - 统一存放jar包的 **空间**
  
- 坐标
  - 仓库中 **定位** 具体jar包位置的标识
  - 选用jar包时需要先 **定位** 到具体位置

- 依赖
  - 是pom文件中对jar引用的 **配置**

  - 还需要 **配置** 对jar包的使用方式

  - 坐标是依赖必选的配置项

  - 【扩展】scope可以指定引用范围, 默认是compile。

    | 依赖范围 | 说明     | 编译是否有效 | 测试是否有效 | 运行是否有效 | 是否打包 | 实际应用    |
    | -------- | -------- | ------------ | ------------ | ------------ | -------- | ----------- |
    | compile  | 编译范围 | √            | √            | √            | √        | ssm         |
    | test     | 测试范围 | √            | √            | ×            | ×        | junit       |
    | provided | 容器范围 | √            | √            | ×            | ×        | servlet-api |
    | runtime  | 运行范围 | ×            | √            | √            | √        | jdbc驱动    |



#### 3. Maven的使用

- 项目演示: maven-day02-parent
- 使用案例: 在pom文件中添加如下配置

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```



#### 小结

- Maven是什么?

  - 
- 复习了哪些相关概念?

  - 
  - 
  - 

- 怎么使用maven下载jar包?
  - 





### 02特性 - 依赖传递【理解】

#### 目标

- 理解依赖传递

- 理解版本冲突

  

#### 1. 理解依赖传递

![1558322911976](assets/1558322911976.png) 

- 依赖案例: activemq-core
  
  ```xml
  <!-- 该依赖内部有详细的日志打印 -->
  <dependency>
      <groupId>org.apache.activemq</groupId>
      <artifactId>activemq-core</artifactId>
      <version>5.7.0</version>
  </dependency>
  ```
  
  
  
- 这种默认行为的好处
  
  - 当前项目也用到slf4j-api的功能时 不需要再次依赖 (**消除重复**) 
  - 无需关心依赖包activemq-core **内部的依赖关系**







#### 2. 理解版本冲突

![1558324837432](assets/1558324837432.png)

##### 2.1 版本冲突

- **短路优先**: 最终采用距离最近的依赖版本

  ![1558324946148](assets/1558324946148.png)

- **手动排除**: 使用exclusion排除依赖

  ```xml

  ```



##### 2.2 传递阻止

- 可以使用optional标签可以阻止继续传递

```xml

```



#### 小结

- 什么是依赖传递?
  - 
- 依赖传递导致了什么问题?
  - 



### 03高级特性 - 继承【理解】

#### 目标

- 什么是继承
- **如何去继承**
- 继承的作用



#### 1. 什么是继承

![1558320682888](assets/1558320682888.png) 

- 继承是 **消除重复** 的一种手段 (方式/特性)



#### 2. 如何去继承

- 在子工程使用parent标签继承父工程

```xml

```



#### 3. 继承的作用

- 继承依赖
  
  - 父工程的依赖会传递给子工程
  
- 继承变量
  - 父工程变量配置

    ```xml
    
    ```

  - 子工程变量引用

    ```xml
    
    ```

- 版本控制

  - 使用dependencyManagement标签在父工程定义版本依赖
  
    ```xml
    
    ```
  
  - 子工程使用时不需要指定版本号
  
    ```xml
    
    ```

- 效果如下

![1559979823587](assets/1559979823587.png) 



#### 小结

- 继承的作用是什么?
  - 
- 如何去继承 (**解除**) ?
  - 



### 04高级特性 - 聚合【理解】

#### 目标

- 实现聚合的 **标签**
- 聚合工程的 **作用**



#### 1. 实现聚合的标签

- **更改打包类型**: 在pom文件中将packaging设置为pom类型

  ```xml
  <!-- 聚合工程必须是pom类型 -->
  <packaging>pom</packaging>
  ```

- **聚合其他工程**: 在pom文件中用module标签聚合其他工程

  ```xml
  <modules>
      <!-- 聚合其他工程 -->
  	<module>被聚合工程的路径</module>
  </modules>
  ```

  

#### 2. 聚合工程的作用

![1558937245863](assets/1558937245863.png)

- 将聚合工程的 **操作同步** 在被聚合工程进行

- 编译演示

  - 创建聚合工程: maven-day02-agg

  - 聚合其他工程: <modules

  ```xml
  
  ```

  

#### 小结

- 如何聚合其他工程?
  - 
- 聚合的作用是什么?
  - 





### 05常见插件【了解】

#### 目标

- 了解插件的概念
- 了解compiler和tomcat7插件的用法



#### 1. 插件的概念

- 插件是某种功能的maven工具
  - 
  - 
- 插件是以 **jar包** 形式存在仓库



#### 2. 插件的用法

- 在pom.xml文件中配置如下

```xml
<build>
    <plugins>
        <!-- java 编译插件 -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>UTF-8</encoding>
            </configuration>
        </plugin>
        <!-- tomcat7容器插件 -->
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <!-- 指定端口 -->
                <port>8080</port>
                <!-- 请求路径 -->
                <path>/</path>
            </configuration>
        </plugin>
    </plugins>
</build>
```



#### 小结

- Maven插件是什么?
  - 
- compile插件的作用是什么?
  - 
- tomcat7插件的作用是什么?
  - 



### 06远程仓库 - 私服【了解】

#### 目标

- 中央仓库的缺点
- 什么是私服
- 如何搭建私服



#### 1. 中央仓库的缺点

- **下载慢**: [http://repo1.maven.org/maven2/](http://repo1.maven.org/maven2/) 
- **访问限制**: 重复下载多次jar包会被加入黑名单

![1558945517758](assets/1558945517758.png) 

 

#### 2. 什么是私服

- **私服是远程仓库的1种** (搭建在局域网中) 
- 私服的作用 (好处)
  - 解决访问限制问题
  - 即使不能上网也可以下载jar包
  - 可以上传自己的jar包



#### 3. 如何搭建私服

- 下载
  - nexus: [官网下载](https://help.sonatype.com/repomanager2/download#Download-OlderOSSversions(notrecommended)) 
  - 课前资料中已经下载 “ nexus-2.12.0-01-bundle.zip ” 。
  - 课前资料中 “nexus-2.1.2.war”可以放置在 tomcat 的 webapps 目录下使用。
- 安装
  - 方式一: 控制台启动
    1. 解压“nexus-2.12.0-01-bundle.zip” 
    2. 修改默认端口, 路径为：nexus-2.12.0-01\conf\nexus.properties
    3. “ nexus-2.12.0-01\bin\jsw\windows-x86-64\ ” 目录下, 双击 console-nexus.bat 为后台启动 nexus

  - 方式二: 服务启动
    1. 双击“install-nexus.bat”则会注册为一个 windows 服务
    2. 访问: [http://localhost:8081/nexus](http://localhost:8081/nexus)
    3. 默认管理员账户: admin|admin123 



#### 小结

- 中央仓库的缺点有哪些?
  - 
- 什么是私服?
  - 

- 启动私服有哪两种方式?
  - 
  - 



### 07私服的应用【掌握】

#### 目标

- **认识私服** 仓库类型
- **使用私服** 下载资源
- **上传自己的jar包** (两种方式)



#### 1. 认识私服的仓库类型

- proxy：代理仓库, 最终jar来源于代理的远程仓库
- hosted： 宿主仓库, 最终的jar来源于用户上传的
- virtual：虚拟仓库, 兼容maven1版本的中央仓库
- group：仓库组, 配置和下载的统一地址



#### 2. 项目中使用私服下载资源

- 在settings.xml文件中配置镜像拦截

```xml
<!-- 远程仓库配置 -->
<mirror>
    <!-- ID -->
    <id>nexus</id>
    <!-- 名称: 私服 -->
    <name>nexus</name>
    <!-- 下载地址 -->
    <url>http://127.0.0.1:8081/nexus/content/groups/public/</url>
    <!-- 拦截请求 -->
    <mirrorOf>central</mirrorOf>
</mirror>
```



#### 3. 上传自己的jar包

- 任何人都能往私服中上传jar包吗?
  - 不能, 需要认证信息 (登陆)



##### 2.1 自动上传方式

- 在pom.xml文件中配置如下

```xml
<distributionManagement>
    <repository>
        <id>releases</id>
        <name>Internal Releases</name>
        <url>http://localhost:8081/nexus/content/repositories/releases/</url>
    </repository>
    <snapshotRepository>
        <id>snapshots</id>
        <name>Internal Snapshots</name>
        <url>http://localhost:8081/nexus/content/repositories/snapshots/</url>
    </snapshotRepository>
</distributionManagement>
```
- 在settings.xml文件中配置如下
```xml
<servers>
    <!-- 服务器认证信息 -->
    <server>
        <!-- ID应与POM中对应 -->
        <id>releases</id>
        <username>admin</username>
        <password>admin123</password>
    </server>
    <server>
        <id>snapshots</id>
        <username>deployment</username>
        <password>deployment123</password>
    </server>
</servers>
```

- 上传命令: `mvn deploy`



##### 2.2 后台上传方式

1. 进入后台选中3rd party仓库 
2. 进入-Select GAV Definition Source 
3. 下拉滚动条进入-Select Artifact(s) for Upload 

![1559981287039](assets/1559981287039.png) 

![1559981377005](assets/1559981377005.png) 



#### 小结

- 仓库类型: proxy代表的是什么?
  - 
- 如何使用私服下载资源?
  - 
- 如何上传自己的jar包?
  - 



### 08整合SSM - 模块化【理解】

#### 目标

- **理解模块化系统结构**



#### 1. 理解模块化系统结构

##### 1.1 旧系统结构的缺点

![1558075239425](assets/1558075239425.png)  



##### 1.2 模块化系统结构

![1556861714918](assets/1556861714918.png) 

#### 小结

- 以前的系统结构缺点

  - 

- 模块化系统结构利用了哪些maven特性?

  - 
  - 
  - 

  

### 09整合SSM - 父工程【理解】

#### 目标

- **创建父工程**: maven-day02-ssm



#### 创建父工程

- 继承配置

```xml
<!--统一管理依赖包版本-->
<properties>
    <!--spring 版本-->
    <spring.version>5.0.2.RELEASE</spring.version>
    <!-- log4j日志包版本 -->
    <slf4j.version>1.7.7</slf4j.version>
    <log4j.version>1.2.17</log4j.version>
    <!-- jstl标签版本 -->
    <jstl.version>1.2</jstl.version>
    <!--servlet版本-->
    <servlet.version>2.5</servlet.version>
    <!--jsp版本-->
    <jsp.version>2.0</jsp.version>
    <!-- mybatis版本号 -->
    <mybatis.version>3.4.5</mybatis.version>
    <!--mysql驱动版本-->
    <mysql.version>8.0.15</mysql.version>
    <!-- mybatis-spring整合包版本 -->
    <mybatis.spring.version>1.3.1</mybatis.spring.version>
    <!--druid版本-->
    <druid.version>1.0.29</druid.version>
    <!-- aspectj版本号 -->
    <aspectj.version>1.6.12</aspectj.version>
</properties>

<!--统一管理依赖包-->
<dependencyManagement>
    <dependencies>
        <!--spring依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- spring web包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- spring mvc包 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--spring jdbc包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--spring tx包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--aspectj包-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
        <!-- jstl标签类 -->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>${jstl.version}</version>
            <optional>true</optional>
        </dependency>
        <!--servlet依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>${servlet.version}</version>
            <scope>provided</scope>
        </dependency>
        <!--jsp依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jsp-api</artifactId>
            <version>${jsp.version}</version>
            <scope>provided</scope>
        </dependency>
        <!-- mybatis核心包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <!-- mybatis-spring整合包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis.spring.version}</version>
        </dependency>
        <!-- mysql数据库依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
            <scope>runtime</scope>
        </dependency>
        <!--数据库连接池druid-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>
        <!-- log4j包 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

- 聚合配置

```xml
<!--父工程packaging，必须设置为pom-->
<packaging>pom</packaging>
<!--聚合子工程-->
<modules>
    <module>maven-day02-domain</module>
    <module>maven-day02-dao</module>
    <module>maven-day02-service</module>
    <module>maven-day02-web</module>
</modules>
```

- 插件配置

```xml
<!--统一配置java编译插件-->
<build>
    <plugins>
        <!-- java 编译插件 -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.2</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>UTF-8</encoding>
            </configuration>
        </plugin>
        <!--配置tomcat插件-->
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.1</version>
            <configuration>
            	<!-- tomcat 的端口号 -->
                <port>8080</port>
                <!-- 访问应用的路径 -->
                <path>/ssm</path>
                <!-- URL按UTF-8进行编码，解决中文参数乱码 -->
                <uriEncoding>UTF-8</uriEncoding>
                <!-- tomcat名称 -->
                <server>tomcat7</server>
            </configuration>
        </plugin>
    </plugins>
</build>
```



#### 小结

- 父工程使用了哪些maven特性?

  - 
  - 
  
- 父工程的版本控制会将依赖下载吗?

  - 

  



### 10整合SSM - domain【理解】

#### 目标

- 创建maven-day02-domain实体类子工程

![1556861714918](assets/1556861714918.png) 

#### 创建实体类工程

- pom.xml

```xml

```

- 实体类

```java

```



#### 小结

- 实体类工程需要外部依赖吗?
  - 





### 11整合SSM - dao【理解】

#### 目标

- 创建maven-day02-dao持久层子工程

![1556861714918](assets/1556861714918.png) 

#### 1. 创建持久层工程

- pom.xml

```xml

```

- dao

```java

```

#### 小结

- 为什么依赖中不需要指定版本号?
  - 



### 12整合SSM - service【理解】

#### 目标

- 创建maven-day02-service业务层子工程

![1556861714918](assets/1556861714918.png) 

#### 1. 创建业务层工程

- pom.xml

```xml

```

- service

```java

```



#### 小结

- 业务层依赖了什么jar包?
  - 



### 13整合SSM - web【理解】

#### 目标

- 创建maven-day02-web控制层子工程



![1556861714918](assets/1556861714918.png) 

#### 创建控制层工程

- pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
  <parent> 
    <artifactId>maven-day02-ssm</artifactId>  
    <groupId>com.itheima</groupId>  
    <version>1.0-SNAPSHOT</version> 
  </parent>  
  <modelVersion>4.0.0</modelVersion>  
  <artifactId>maven-day02-web</artifactId>
    
  <!-- WEB工程的打包类型是war(不指定默认是jar将无法启动web项目) -->
  <packaging>war</packaging>


  <!--配置依赖-->
  <dependencies>
    <!--依赖maven-day01-09ssm-service-->
    <dependency>
      <groupId>com.itheima</groupId>
      <artifactId>maven-day02-service</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
    <!-- spring web包 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
    </dependency>
    <!-- spring mvc包 -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
    </dependency>
    <!--spring jdbc包-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
    </dependency>
    <!--spring tx包-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
    </dependency>
    <!--aspectj包-->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
    </dependency>
    <!-- jstl标签类 -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
    </dependency>
    <!--servlet依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <scope>provided</scope>
    </dependency>
    <!--jsp依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jsp-api</artifactId>
      <scope>provided</scope>
    </dependency>
    <!-- log4j包 -->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
    </dependency>
    <!-- mybatis-spring整合包 -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
    </dependency>
  </dependencies>
</project>
```

- controller

```java

```

- resources

![1556874872001](assets/1556874872001.png) 



#### 小结

- web子工程与其他子工程有什么不同?
  - 



### 14整合SSM - 启动【理解】

#### 目标

- 启动测试整合项目



#### 1. 启动测试整合项目

##### 1.1 两种启动方式

- 双击 tomcat7:run

- 命令 mvn tomcat7:run

##### 1.2 访问

- 地址: http://localhost:8080/ssm/list.do

##### 1.3 易错点提醒

###### 框架整合

- 扫描注解不能重复扫描同一个包 (影响AOP事务)
- Controller层加入IOC容器必须用@Controller注解 (需要解析请求映射)
- web.xml中的springMvc文件和applicationContext文件不能使用同一个
- 配置文件的路径(如: 日志文件) 需要放置在存在的盘符内 (需要创建日志文件)
- IDE建议不要装在C盘 (有系统权限问题)

###### 私服搭建

- 解压文件时需要全部解压
- 解压目录不要有空格和中文
- 安装或启动时建议右键以管理员身份执行
- 私服配置镜像拦截时mirrorOf是仓库的ID值 (重复将只有第一个生效)
- 上传发布版jar包时需要更改发布仓库支持上传



#### 小结

- 如何选用两种启动方式?

  - 





### 15总结【理解】

- 学习了哪些特性?
  - 
  - 
  - 

- 如何部署私服?
  - 
  - 

- 如何使用私服下载资源?
  - 
- 整合SSM中哪个工程使用了聚合特性?
  - 
- 整合SSM中哪些工程利用了继承特性?
  - 
- 为什么子工程中的坐标没有版本号?
  - 







### 16web - resources【了解】

#### 目标

- 了解web子项目中的各个配置内容

#### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
        http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         id="WebApp_ID" version="2.5">
    
    <!--配置spring提供的监听器：ContextLoaderListener,说明：
        1.ContextLoaderListener监听器，监听ServletContext对象的创建和销毁，一旦ServletContet
        对象创建，就创建spring的容器，并且把spring容器放到ServletContext对象中
        2.该监听器默认只能加载WEB-INF目录下applicationContext.xml文件
        3.通过<context-param>标签配置指定spring配置文件的位置，改变默认的加载位置
    -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!--配置spring的配置文件位置(全局参数)-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring/applicationContext.xml</param-value>
    </context-param>
    
    
    <!--配置前端控制器（DispatcherServlet）-->
    <servlet>
        <servlet-name>ssm</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <!--加载springmvc的主配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/springmvc.xml</param-value>
        </init-param>

        <!--配置tomcat启动就加载前端控制器-->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>ssm</servlet-name>
        <!--配置请求的url规则，说明：
            1.*.do，表示以.do结尾的请求进入前端控制器
            2./，表示所有请求都进入前端控制器
        -->
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
</web-app>
```

#### WEB-INF/jsp/user/list.jsp

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表jsp页面</title>
</head>
<body>
    用户列表：
    <table>
        <tr>
            <th>用户Id</th>
            <th>用户名称</th>
            <th>用户地址</th>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
```

#### spring/applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">


    <!--导入其它模块的配置文件-->
    <import resource="classpath:spring/applicationContext-dao.xml"/>
    <import resource="classpath:spring/applicationContext-service.xml"/>
    <import resource="classpath:spring/applicationContext-trans.xml"/>

</beans>
```

#### applicationContext-dao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--加载属性资源文件,说明：
        context:property-placeholder：加载属性资源文件
    -->
    <context:property-placeholder location="classpath:db.properties"/>

    <!--配置数据源对象-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--注入连接数据库的四个基本要素-->
        <property name="driverClassName" value="${db.driver}"/>
        <property name="url" value="${db.url}"/>
        <property name="username" value="${db.username}"/>
        <property name="password" value="${db.password}"/>
    </bean>

    <!--启动Mybatis创建SqlSession工厂并加入到IOC容器中-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--注入数据源对象DataSource-->
        <property name="dataSource" ref="dataSource"/>

        <!--加载mybatis主配置文件-->
        <property name="configLocation" value="classpath:mybatis/sqlMapConfig.xml"/>
     </bean>

    <!--自动扫描Mapper接口生成代理并添加到IOC容器中-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--配置要扫描的包-->
        <property name="basePackage" value="com.itheima.maven.day02.dao"/>
    </bean>


</beans>
```

#### applicationContext-service.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--配置包扫描service-->
    <context:component-scan base-package="com.itheima.maven.day02.service"/>

</beans>
```

#### applicationContext-trans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!--注入数据源对象-->
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--配置aop-->
    <aop:config>
        <!--配置切入点表达式-->
        <aop:pointcut id="pt1" expression="execution(* com.itheima.maven.day02.service..*.*(..))"/>

        <!--建立通知（事务管理器）与切入点表达式的关系-->
        <aop:advisor advice-ref="txAdvice" pointcut-ref="pt1"/>
    </aop:config>

    <!--配置通知-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--配置事务属性-->
        <tx:attributes>
            <!--配置增删改方法，要求事务-->
            <tx:method name="save*" propagation="REQUIRED" read-only="false"/>
            <tx:method name="add*" propagation="REQUIRED" read-only="false"/>
            <tx:method name="update*" propagation="REQUIRED" read-only="false"/>
            <tx:method name="del*" propagation="REQUIRED" read-only="false"/>

            <!--配置查询的方法，只要支持事务即可-->
            <tx:method name="find*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="get*" propagation="SUPPORTS" read-only="true"/>
            <tx:method name="query*" propagation="SUPPORTS" read-only="true"/>
        </tx:attributes>
    </tx:advice>

</beans>
```

#### spring/springmvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--配置包扫描controller-->
    <context:component-scan base-package="com.itheima.maven.day02.web"/>

    <!--注册: 注解处理映射器 和 注解处理适配器 以及一些其他额外的支持
 		DefaultAnnotationHandlerMapping; AnnotationMethodHandlerAdapter
	-->
    <mvc:annotation-driven/>

    <!--配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!--配置视图的公共目录路径（前缀）-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!--配置视图的扩展名称（后缀）-->
        <property name="suffix" value=".jsp"/>
     </bean>

</beans>
```

#### db.properties

```properties
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql:///mybatisdb?serverTimezone=UTC&useSSL=false
db.username=root
db.password=root
```

#### sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--配置别名-->
    <typeAliases>
        <!--包扫描方式配置别名-->
        <package name="com.itheima.domain"/>
    </typeAliases>

</configuration>
```



#### 小结

- 哪些配置文件需要在web.xml中配置?
  - 

