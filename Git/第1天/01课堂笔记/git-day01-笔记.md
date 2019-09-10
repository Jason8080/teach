### 01复习

#### 目标

- 了解版本控制器



#### 1. 版本控制器

![1567997451245](assets/1567997451245.png) 

##### 1.1 SVN

​	Apache Subversion 通常被缩写成 SVN，是一个开放源代码的 **集中式版本控制系统**，Subversion 在 2000 年由 CollabNet Inc 开发，现在发展成为 Apache 软件基金会的一个项目，同样是一个丰富的开发者和用户社区的一部分。

##### 1.2 作用

- 记录文件修改日志: `git log`
  - 用户A: 2018年修改a.txt文件添加业务需求: `5`, 版本号: d498237e6dc1fc4861c79d3314d07285995o
  - 用户B: 2018年修改a.txt文件修改业务需求: `6`, 版本号: b498237e6dc1fc4861c79d3314d07285995p
  - 用户A: 2019年修改a.txt文件修改业务需求: `7`, 版本号: h498237e6dc1fc4861c79d3314d07285995k

- 还原变更的需求
  - 还原被修改的文件: `git reset --hard`
  - 回滚到指定的版本: `git reset --hard  b498237e6dc1fc4861c79d3314d07285995b`
- 团队协同开发
  - 用户A: 修改的需求`6`可以与用户B的需求`5`进行合并, 选择最佳方案



#### 小结

- Svn的作用是什么?
  - 



### 02Git - 概念【理解】

#### 目标

- 了解Git的历史
- 了解Git的特点
- 了解Git的工作流程



#### 1.  历史

- 林纳斯·托瓦兹（Linus Torvalds）: Linux之父, Linux开源的作者

- 1991－2002年, 源代码的管理大部分时间花在了提交和归档等繁琐的事物上

- 2002年, 代码库之大让 Linus 很难继续通过手工方式管理了，启用BitKeeper来管理和维护代码

- 2005年的时候, 开发 BitKeeper 的商业公司同 Linux 内核开源社区的合作关系结束
- 2005年, Git在Linux长达两周的研发中诞生, 即刻便用于Linux代码管理, 从此Git成为主流

#### 2. 特点

- **速度快**
- 设计简单 
- 分支管理
- **分布式** 
- 超大规模项目 （Linux）

#### 3. 工作流程

1. git clone: 
2. git checkout: 
3. vim file: 
4. git add.
5. git commit: 
6. git push



#### 小结

- Git与Svn的区别是什么?
  - 



### 03Git - 安装【了解】

#### 目标

- 安装客户端环境
- 安装可视化工具



#### 1. 安装客户端环境

##### 1.1 下载

- 官网地址: https://git-scm.com/downloads
- 本地位置: 02课前资料/windows/Git-2.14.1/Git-2.22.0-64-bit.exe

![1567667367372](assets/1567667367372.png)

##### 1.2 安装

- 详见文档: 02课前资料/windows/Git-2.14.1/Windows系统安装Git 2.14.1.docx

- 安装注意: 

  - 选择环境时需要选择windows命令行中使用Git

    ![1568016904747](assets/1568016904747.png) 

  - 选择远程传输需要选择使用OpenSSL

    ![1568017059561](assets/1568017059561.png) 



#### 2. 安装可视化工具

##### 1.1 下载

- 官网地址: https://git-scm.com/download/gui/windows
- 本地位置: 02课前资料/windows/TortoiseGit-2.5.0.0/TortoiseGit-2.5.0.0-64bit.msi
- 工具汉化: 02课前资料/windows/TortoiseGit-2.5.0.0/TortoiseGit-LanguagePack-2.5.0.0-64bit-zh_CN.msi

##### 1.2 安装

- 详见文档: 02课前资料/windows/TortoiseGit-2.5.0.0/Windows系统安装TortoiseGit 2.5.0.0.docx
- 工具汉化: 02课前资料/windows/TortoiseGit-2.5.0.0/Windows系统安装TortoiseGit-LanguagePack..docx



#### 小结

- 可视化工具是否必须?
  - 





### 04Git - 使用【理解】

#### 目标

- 准备Git的使用环境
- 理解Git的系统结构



#### 1. 使用环境

- 前提: 在文件夹下使用
  1. 创建文件夹: `mkdir directory`
  2. 打开Git Bash
  3. 进入文件夹: `cd directory`



#### 2. 系统结构

![1567755550916](assets/1567755550916.png) 

#### 小结

- 哪块区域会形成版本?
  - 







### 05Git - 本地指令【理解】

#### 目标

- 掌握本地指令的使用



#### 1. 本地指令的使用

##### git init

- 作用: 

- .git文件夹
  - 



##### git status

- 作用: 

- 添加a.txt文件
  - 



##### git add

- 作用: 
- 执行git status
  - 



##### vim .gitignore

- 作用: 
- 执行git status
  - 



##### git commit

- 作用: 
- 执行git status
  - 



##### git log

- 作用: 
- 



##### git reset --hard

- 作用:
- 执行vim a.txt
  - 



#### 小结

- .git文件夹的作用是什么?
  - 

- 指令执行的路径有要求吗?
  - 





### 06Git - 远程仓库【理解】

#### 目标

- 了解常见的远程仓库
- 使用码云作为远程仓库



#### 1. 常见的远程仓库

##### 1.1 GitHub

> ​	GitHub是一个面向开源及私有软件项目的托管平台，因为只支持git 作为唯一的版本库格式进行托管，故名GitHub(https://github.com/)。
>
> ​	GitHub于2008年4月10日正式上线，除了Git代码仓库托管及基本的 Web管理界面以外，还提供了订阅、讨论组、文本渲染、在线文件编辑器、协作图谱（报表）、代码片段分享（Gist）等功能。目前，其注册用户已经超过350万，托管版本数量也是非常之多，其中不乏知名开源项目 [Ruby](https://baike.baidu.com/item/Ruby/11419) on Rails、[jQuery](https://baike.baidu.com/item/jQuery/5385065)、[python](https://baike.baidu.com/item/python/407313) 等。
>
> ​	2018年6月4日，微软宣布，通过75亿美元的股票交易收购代码托管平台GitHub。

##### 1.2 码云

> ​	Gitee是开源中国（https://www.oschina.net/）开发的一款基于git的代码托管平台，能够用码云实现代码托管、项目管理、协作开发，目前是国内最大的代码系统，gitee和github的作用和性质是类似的，但是相比于github而言，gitee有两个显著的优势：一是速度快，二是支持免费的私密项目。
>
> ​	码云平台帮助文档http://git.mydoc.io/，账户注册地址: https://gitee.com/signup 。

##### 1.3 GitLab

> ​	GitLab是一个用于仓库管理系统的开源项目, 使用Git作为代码管理工具, 在此基础上搭建起来的web服务。
>
> ​	GitLab是由GitLabInc.开发，使用MIT许可证的基于网络的Git仓库管理工具，且具有wiki和issue跟踪功能。使用Git作为代码管理工具，并在此基础上搭建起来的web服务。
>
> ​	GitLab由乌克兰程序员DmitriyZaporozhets和ValerySizov开发，它使用Ruby语言写成。后来，一些部分用Go语言重写。截止2018年5月，该公司约有290名团队成员，以及2000多名开源贡献者。GitLab被IBM，Sony，JülichResearchCenter，NASA，Alibaba，Invincea，O’ReillyMedia，Leibniz-Rechenzentrum(LRZ)，CERN，SpaceX等组织使用。

#### 2. 远程仓库 - 码云

1. 注册登录: https://gitee.com/signup
2. 创建仓库: https://gitee.com/projects/new
3. 仓库地址: https://gitee.com/gm_lee/teachGit.git





#### 小结

- 常见的远程仓库有哪些?
  - 
  - 
  - 



### 07Git - 远程指令【理解】

#### 目标

- 掌握远程指令的使用



#### 1. 远程指令的使用

##### git remote -v

- 作用: 



##### git remote add origin url

- 作用: 
- 执行git remote -v查看远程版本库
  - 



##### git clone 

- 作用:
- 观察当前目录变化
  - 
- 执行git log查看日志
  - 



##### git push

- 作用: 
- 执行git log查看日志
  - 



##### git pull

- 作用:
- 查看a.txt文件的变化
  - 





#### 小结

- 什么情况下使用克隆?
  - 



### 08Git - 版本冲突【理解】

#### 目标

- 理解版本冲突
- 解决版本冲突



#### 1. 版本冲突

![1567997451245](assets/1567997451245.png) 

#### 2. 解决冲突

1. 执行git pull
2. 自动合并版本
3. 查看合并内容

![1567744548196](assets/1567744548196.png)



#### 小结

- 什么情况下会发生版本冲突?
  - 



### 09Git - 分支指令【理解】

#### 目标

- 理解分支的概念
- 掌握分支的指令



#### 1. 分支的概念

![1567757114089](assets/1567757114089.png)

#### 2. 分支的指令

##### git branch

- 作用: 



##### git branch dev

- 作用: 
- 执行git branch
  - 



##### git checkout dev

- 作用: 
- 执行git branch
  - 
- 修改a.txt文件
- 执行git checkout master
- 查看a.txt文件内容
  - 



##### git merge dev

- 作用:
- 查看a.txt文件内容
  - 
- 执行git log查看日志
  - 





#### 小结

- 合并后会保留分支的版本吗?
  - 



### 10Git - Idea操作【掌握】

#### 目标

- 在idea中使用Git



#### 1. idea中使用

##### 1.1 准备环境

![1567768800812](assets/1567768800812.png) 

##### 1.2 本地仓库

###### 初始化版本库

![1567769275607](assets/1567769275607.png) 

###### 忽略指定文件

![1567769565930](assets/1567769565930.png) 

###### 添加到暂存区

![1567769718115](assets/1567769718115.png) 

###### 提交本地仓库

![1567769809260](assets/1567769809260.png) 

##### 1.3 远程仓库

###### 关联远程仓库

![1567770358615](assets/1567770358615.png) 

###### 克隆远程仓库

![1567771239581](assets/1567771239581.png) 



###### 推送远程仓库

![1567770499837](assets/1567770499837.png)

- 登陆

  ![1567770542718](assets/1567770542718.png) 

- 忘记密码: 同5.2.3忘记密码

###### 拉取远程版本

![1567770697755](assets/1567770697755.png) 

![1567771295684](assets/1567771295684.png) 

###### 修改远程仓库

![1567770937008](assets/1567770937008.png)  

##### 1.4 版本冲突

###### 添加README.md文件

![1567772040226](assets/1567772040226.png) 

###### idea拉取远程版本

![1567772243216](assets/1567772243216.png) 



###### 登陆gm_01更新README.md

![1567772437245](assets/1567772437245.png) 

###### idea修改README.md

![1567772543299](assets/1567772543299.png) 

###### 处理版本冲突

![1567773210511](assets/1567773210511.png) 



##### 1.5 分支管理

###### 创建新分支

![1568086605839](assets/1568086605839.png) 

###### 切换已有分支

![1568087152703](assets/1568087152703.png) 

###### 合并dev分支

![1568087692890](assets/1568087692890.png) 



#### 小结

- idea操作与执行指令有区别吗?
  - 



### 11总结

1. Git与Svn的区别?
   - 
2. Git结构有哪些区域?
   - 
   - 
   - 
3. 文件夹.git文件的作用?
   - 
4. 说出以下指令的作用?
   - git init: 
   - git add: 
   - git commit: 
5. 远程仓库相关的指令有哪些?
   - 
   - 
   - 
   - 
6. 什么是版本冲突?
   - 
7. 请说出以下指令的作用?
   - git branch: 
   - git checkout: 
   - git merge: 
8. idea操作与执行命令的区别?
   - 





### 12Git - GitLab【了解】

#### 目标

- 搭建GitLab服务器



#### 1. 搭建GitLab服务器

1. 下载安装包到 `/opt/` 目录 (**10分钟**)

   - 浏览器下载: `https://packages.gitlab.com/gitlab/gitlab-ce/packages/el/7/gitlab-ce-12.1.4-ce.0.el7.x86_64.rpm/download.rpm`  
   - 使用本地文件: 02课前资料/gitlab/gitlab-ce-12.1.4-ce.0.el7.x86_64.rpm
   - linux下载: `wget --content-disposition https://packages.gitlab.com/gitlab/gitlab-ce/packages/el/7/gitlab-ce-12.1.4-ce.0.el7.x86_64.rpm/download.rpm` 

2. 准备GitLab安装环境 (**10分钟**)

   ```shell
   sudo rpm -ivh /opt/gitlab-ce-12.1.4-ce.0.el7.x86_64.rpm
   sudo yum install -y curl policycoreutils-python openssh-server cronie
   sudo lokkit -s http -s ssh
   sudo yum install postfix
   sudo service postfix start
   sudo chkconfig postfix on
   curl https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.rpm.sh | sudo bash
   sudo EXTERNAL_URL="http://gitlab.example.com" yum -y install gitlab-ce
   ```

3. reboot ( **重启** )

4. 初始化GitLab与启动 (**10分钟**)

   ```shell
   # 启动服务
   gitlab-ctl reconfigure
   # 启动所有gitlab组件
   gitlab-ctl start
   # 停止服务
   gitlab-ctl stop
   ```

5. 登陆: root|12345678



#### 小结

- 安装过程中需要联网吗?
  - 



### 13Git - Gitblit【了解】

#### 目标

- 搭建Gitblit服务器



#### 1. 搭建Gitblit服务器

1. 下载压缩包: 02课前资料/gitblit/gitblit-1.8.0.zip

2. 解压

3. 修改F:\software\gitblit-1.8.0\data\defaults.properties

   ```properties
   server.httpPort = 10101
   ```

4. 打开命令行: 执行 `gitblit.cmd`

5. 访问: http://localhost:10101/ 或  https://localhost:8443/

   ![1568109699975](assets/1568109699975.png) 

   

   

#### 小结

- Https默认端口是什么?
  - 













