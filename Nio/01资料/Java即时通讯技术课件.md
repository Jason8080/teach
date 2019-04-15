## 前言

### 目标

​	学习网络编程, 提升就业能力。

### 大纲

![1555059069147](assets/1555059069147.png)



## 基础知识 

### 即时通讯

#### 简介

　　即时通讯开发技术，也叫音视频即时通信开发技术。随着互联网的发展，即时通讯开发技术的逐步成熟，人们之间的交流逐步从电话移向网络。每天都有相当多的人在使用各种网络交流工具，如[腾讯QQ](https://baike.baidu.com/item/%E8%85%BE%E8%AE%AFQQ/112243)，[ICQ](https://baike.baidu.com/item/ICQ/97139)，MSN，Message，新浪微博。

　　ICQ是互联网上最早的[即时通讯](https://baike.baidu.com/item/%E5%8D%B3%E6%97%B6%E9%80%9A%E8%AE%AF)软件。

　　1996年，三个以色列人[维斯格](https://baike.baidu.com/item/%E7%BB%B4%E6%96%AF%E6%A0%BC)、瓦迪和高德芬格聚在一起，决定开发一种使人与人在互联网上能够快速直接交流的软件。他们为新软件取名ICQ，即“I SEEK YOU（我找你）”的意思。ICQ支持在Internet上聊天、发送消息、传递文件等功能。他们成立了Mirabilis公司，向注册用户提供互联网[即时通讯](https://baike.baidu.com/item/%E5%8D%B3%E6%97%B6%E9%80%9A%E8%AE%AF)（Instant Messenger， IM）服务。ICQ的使用用户快速增长（案例资料 TX－1），6个月后，ICQ宣布成为当时世界上[用户量](https://baike.baidu.com/item/%E7%94%A8%E6%88%B7%E9%87%8F)最大的[即时通讯软件](https://baike.baidu.com/item/%E5%8D%B3%E6%97%B6%E9%80%9A%E8%AE%AF%E8%BD%AF%E4%BB%B6)。在第7个月的时候，ICQ的正式用户达到100万。1998年，ICQ被[美国在线](https://baike.baidu.com/item/%E7%BE%8E%E5%9B%BD%E5%9C%A8%E7%BA%BF)以4.07亿美元收购，此时其用户数超过1000万。 

#### 功能

　　提示你何时朋友和同事连接到互联网上，并可以通过这个软件相互交流。

　　接收你朋友的生日并把你自己的生日提前通知大家。

　　创建你自己的ICQ主页，当你在线的时候别人就可以访问你的主页。

　　利用贺卡、语音邮件等ICQ插件发送贺卡和语音邮件。

　　利用ICQEmail发送、转寄和复制电子邮件。

　　使用你喜欢的字体、字号和颜色发送消息。

　　为不同的事件选择声音以及配置打字的声音效果。

　　把你的朋友和同事分到不同的分组内。

　　可以在聊天中插入动作和表情，等等。 [1]  

#### 预览

![1554107378415](assets/1554107378415.png) 　　



### 网络编程

#### 简介

　　网络编程的本质是两个设备之间的数据交换，当然，在计算机网络中，设备主要指计算机。数据传递本身没有多大的难度，不就是把一个设备中的数据发送给另外一个设备，然后接受另外一个设备反馈的数据。

　　现在的网络编程基本上都是基于请求/响应方式的，也就是一个设备发送请求数据给另外一个，然后接收另一个设备的反馈。

　　在网络编程中，发起连接程序，也就是发送第一次请求的程序，被称作 **客户端(Client)**，等待其他程序连接的程序被称作 **服务器(Server)**。客户端程序可以在需要的时候启动，而服务器为了能够时刻相应连接，则需要一直启动。例如以打电话为例，首先拨号的人类似于客户端，接听电话的人必须保持电话畅通类似于服务器。

　　连接一旦建立以后，就客户端和服务器端就可以进行数据传递了，而且两者的身份是等价的。

　　在一些程序中，程序既有客户端功能也有服务器端功能，最常见的软件就是BT、emule这类软件了。

#### 地址

　　在现实生活中，如果要打电话则需要知道对应人的电话号码，如果要寄信则需要知道收信人的地址。在网络中也是这样，需要知道一个设备的位置，则需要使用该设备的IP地址，具体的连接过程由硬件实现，程序员不需要过多的关心。

　　IP地址是一个规定，现在使用的是IPv4，既由4个0-255之间的数字组成，在计算机内部存储时只需要4个字节即可。在计算机中，IP地址是分配给网卡的，每个网卡有一个唯一的IP地址，如果一个计算机有多个网卡，则该台计算机则拥有多个不同的IP地址，在同一个网络内部，IP地址不能相同。IP地址的概念类似于电话号码、身份证这样的概念。

　　由于IP地址不方便记忆，所以有专门创造了域名(Domain Name)的概念，其实就是给IP取一个字符的名字，例如163.com、sina.com等。IP和域名之间存在一定的对应关系。如果把IP地址类比成身份证号的话，那么域名就是你的姓名。

　　其实在网络中只能使用IP地址进行数据传输，所以在传输以前，需要把域名转换为IP，这个由称作DNS的服务器专门来完成。

　　所以在网络编程中，可以使用IP或域名来标识网络上的一台设备。

#### 端口

　　为了在一台设备上可以运行多个程序，人为的设计了端口(Port)的概念，类似的例子是公司内部的分机号码。

　　规定一个设备有216个，也就是65536个端口，每个端口对应一个唯一的程序。每个网络程序，无论是客户端还是服务器端，都对应一个或多个特定的端口号。由于0-1024之间多被操作系统占用，所以实际编程时一般采用1024以后的端口号。

　　使用端口号，可以找到一台设备上唯一的一个程序。

　　所以如果需要和某台计算机建立连接的话，只需要知道IP地址或域名即可，但是如果想和该台计算机上的某个程序交换数据的话，还必须知道该程序使用的端口号。

#### 小结

　　IP是网络中计算机的唯一标识, Port是计算机中应用程序的唯一标识; 

　　使用IP和Port可以在网络中定位一个应用程序, 随即进行数据交换(通讯)。



### 数据传输

　　在网络上，不管是有线传输还是无线传输，数据传输的方式有两种

#### TCP

　　TCP(Transfer Control Protocol)传输控制协议方式，该传输方式是一种稳定可靠的传送方式，类似于显示中的打电话。只需要 **建立一次连接**，就可以多次传输数据。就像电话只需要拨一次号，就可以实现一直通话一样，如果你说的话不清楚，对方会要求你重复，保证传输的数据可靠。

　　使用该种方式的优点是稳定可靠，缺点是建立连接和维持连接的代价高，传输速度不快。

#### UDP

　　UDP(User Datagram Protocol)用户数据报协议方式，该传输方式 **不建立稳定的连接**，类似于发短信息。每次发送数据都直接发送。发送多条短信，就需要多次输入对方的号码。该传输方式不可靠，数据有可能收不到，系统只保证尽力发送。

　　使用该种方式的优点是开销小，传输速度快，缺点是数据有可能会丢失。

　　在实际的网络编程中，大家可以根据需要选择任何一种传输方式，或组合使用这两种方式实现数据的传递。

#### IO流

　　UDP(无连接)通讯, 只需将数据封包, 即可按数据块的方式传递。

　　TCP(有连接)通讯, 需建立连接通道, 方可在通道中输入或输出。

　　TCP通讯的数据传输是**IO流**的形式: 往连接通道读/写(Input/Output)数据, 数据按照固定的流向运动。



#### 面试题

　　1. ==说说TCP与UDP的区别?==

　　TCP是面向连接的通讯协议, 以数据流传输数据, 是可靠的通讯方式;

　　UDP是面向无连接的通讯协议, 以数据包传输数据, 是高效的通讯方式;



### 通讯模型

　　按POSIX标准来分，IO分为同步和异步(**实际上同步与异步是针对应用程序与内核的交互而言的** )。

　　在介绍IO模型之前，需要先了解应用程序IO的过程，一般来说，一个IO分为两个阶段

应用程序向操作系统发出IO请求：应用程序发出IO请求给操作系统内核，操作系统内核需要等待数据就绪，这里的数据可能来自别的应用程序或者网络

 	1. 等待数据：数据可能来自其他应用程序或者网络，没有数据，操作系统就一直等待，应用程序就跟着等待。
		2. 拷贝数据：将就绪的数据拷贝到应用程序工作区。

#### 阻塞(BIO)

　　正如上面的IO操作的步骤，当应用程序发起IO请求之后，操作系统就要处理系统调用recvfrom()，在这个过程中，操作系统需要等待数据就绪（数据可能来自别的应用程序的输入或者网络），应用程序则不再处理别的事情，而是一直**等待**（即阻塞状态）数据就绪，然后操作系统完成IO操作，然后recvfrom()才方法返回，应用程序才继续执行，这就是阻塞式IO模型。下图描述了阻塞式IO模型 

![img](assets/795235-20161208175600241-333223016.png)  

#### 非阻塞(NIO)

　　当应用程序发起了IO请求之后，系统调用recvfrom()被执行，并且立即返回，但是返回的并不是IO处理完成的结果，而是一个特定的错误，表示IO数据没有准备好，因此不需要进行IO操作。应用程序会不停地（即**轮询**）执行recvfrom()系统调用，直到数据已经就绪，然后操作系统完成IO操作，recvfrom()返回成功。这个过程中，没有数据就绪时系统调用recvfrom()是立即返回的，即应用程序并没有阻塞在底层操作系统的等待数据上面，而是轮询结果。这个过程可以用下图表示，

　　可见阻塞IO与非阻塞IO的关键区别在于，系统调用recvfrom是否立即返回。由于轮询会消耗大量CPU时间，因此这种模式并不常用。

![img](assets/795235-20161208180531866-1294544171.png)  



#### 多路复用

　　前面的非阻塞IO将会轮询一个IO是否可用，而IO复用则是轮询**多个IO**是否至少有一个可用。

　　IO复用的关键在于select()函数。在阻塞IO中，应用程序阻塞在一个IO的内核操作上；

　　但在多路复用中，通过select()，可以同时监听多个IO请求的内核操作，只要有任意一个IO的内核操作就绪，都可以通知select()返回，再进行系统调用recvfrom()完成IO操作。

这个过程应用程序就可以同时监听多个IO请求，这比起基于多线程阻塞式IO要先进得多，因为服务器只需要一两个线程就可以进行多客户端通信。IO复用可用下图表示

![img](assets/795235-20161208182733007-1325239705.png)  

#### 信号驱动

　　在unix系统中，应用程序发起IO请求时，可以给IO请求注册一个信号函数，请求立即返回，操作系统底层则处于等待状态（等待数据就绪），直到数据就绪，然后通过信号通知主调程序，主调程序才去调用系统函数recvfrom()完成IO操作。

　　信号驱动也是一种非阻塞式的IO模型，比起上面的非阻塞式IO模型，信号驱动式IO模型不需要轮询检查底层IO数据是否就绪，而是被动接收信号，然后再**调用recvfrom**执行IO操作。

　　比起多路复用IO模型来说，信号驱动IO模型针对的是一个IO的完成过程， 而多路复用IO模型针对的是多个IO同时进行时候的场景。 信号驱动式IO模型用下图表示

![img](assets/795235-20161208184254976-2041108433.png)  

#### 异步(AIO)

　　异步IO模型的工作机制是，将整个IO操作（包括等待数据就绪，复制数据到应用程序工作空间）全都交给操作系统完成，操作系统完成整个过程之后，再通知应用程序。

　　异步IO模型跟信号驱动IO模型很相似，但是区别是信号驱动模型是在数据就绪的时候通知应用程序，应用程序再调用系统函数recvfrom进行IO操作。

　　而异步IO模型则是数据就绪且操作系统已经将数据拷贝进应用程序运行空间之后，操作系统再通知应用程序，这个过程中应用程序不需要阻塞。异步IO可以如下图表示

![img](assets/795235-20161208185905304-1734361836.png) 

#### IO模型对比

　　可见前面四种IO模型中，应用程序都会在某一环节阻塞（即使是轮询，也算是一种阻塞），POSIX将这种IO模型称为同步IO操作，

　　而异步IO模型，则是全权把IO操作整个过程都交给操作系统，**中途无阻塞**，POSIX将这种IO模型称为异步IO操作。  以上所有IO对比如下图

![img](assets/795235-20161208185934491-1881555264.png) 

#### 面试题1

　　==说说同步与异步的区别？==

　　同步是指应用程序执行某操作时, 会在某一环节阻塞。

　　异步是指应用程序执行某操作时, 全程无阻塞。

#### 面试题2

　　==说说BIO,NIO,AIO的区别？==

　　BIO是jdk1.4以前就支持的同步阻塞IO模型。

　　NIO是jdk1.4以后支持的同步非阻塞IO模型。

　　AIO是jdk1.7以后支持的异步IO模型。



### AIO编程

#### 简介

　　Linux 异步 I/O 是 Linux 内核中提供的一个相当新的增强。它是 2.6 版本内核的一个标准特性，但是我们在 2.4 版本内核的补丁中也可以找到它。AIO 背后的基本思想是**允许进程发起很多 I/O 操作，而不用阻塞或等待任何操作完成**。稍后或在接收到 I/O 操作完成的通知时，进程就可以检索 I/O 操作的结果。 

在JDK1.7中，这部分内容被称作NIO.2，主要在java.nio.channels包下增加了下面四个异步通道：

- AsynchronousSocketChannel
- AsynchronousServerSocketChannel
- AsynchronousFileChannel
- AsynchronousDatagramChannel

其中的read/write方法，会返回一个带回调函数的对象，当执行完读取/写入操作后，直接调用回调函数。



#### 缓冲区

　　简单地说就是一块存储区域，或者可以换种说法，从代码的角度来讲（可以查看JDK中Buffer、ByteBuffer、DoubleBuffer等的源码），Buffer类内部其实就是一个基本数据类型的数组，以及对这个缓冲数组的各种操作；

常见的缓冲区如ByteBuffer、IntBuffer、DoubleBuffer...内部对应的数组依次是byte、int、double...

　　在Java NIO中，缓冲区主要是跟通道（Channel）打交道，数据总是从缓冲区写入到通道中，或者从通道读取数据到缓冲区； 



##### 容量（capacity）

　　capacity指的是缓冲区能够容纳元素的最大数量，这个值在缓冲区创建时被设定，而且不能够改变； 

##### 上界（limit）

　　limit指的是缓冲区中第一个不能读写的元素的数组下标索引，也可以认为是缓冲区中实际元素的数量；

##### 位置（position）

　　position指的是下一个要被读写的元素的数组下标索引，该值会随get()和put()的调用自动更新； 

##### 标记（mark）

　　一个备忘位置，调用mark()方法的话，mark值将存储当前position的值，等下次调用reset()方法时，会设定position的值为之前的标记值； 



##### 属性关系

　　0 <= mark <= position <= limit <= capacity 



#### 演示

##### 创建buffer

###### 说明

- **HeapByteBuffer**

  ```java
  // 构建cap=10的HeapByteBuffer
  ByteBuffer buffer = ByteBuffer.allocate(10);
  // 构建cap=bytes.length的HeapByteBuffer; 并指定pos=1,limit=1+1
  ByteBuffer buffer = ByteBuffer.wrap(new byte[]{1,2}, 1, 1);
  ```

- DirectByteBuffer

  ```java
  // 构建cap=10的DirectByteBuffer
  ByteBuffer buffer = ByteBuffer.allocateDirect(10);
  ```

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 打印
    System.out.println(buffer);
}
```

###### 演示

> Connected to the target VM, address: '127.0.0.1:52766', transport: 'socket'
>
> Disconnected from the target VM, address: '127.0.0.1:52766', transport: 'socket'
> **java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]**
>
> Process finished with exit code 0

###### 源码

```java
public static ByteBuffer allocate(int capacity) {
    if (capacity < 0)
        throw new IllegalArgumentException();
    return new HeapByteBuffer(capacity, capacity);
}
```

##### 添加byte

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
        .put((byte) 3).put((byte) 4).put((byte) 5);
    // 打印
    System.out.println(buffer);
}
```

###### 演示

> Connected to the target VM, address: '127.0.0.1:52819', transport: 'socket'
> **java.nio.HeapByteBuffer[pos=5 lim=10 cap=10]**
> Disconnected from the target VM, address: '127.0.0.1:52819', transport: 'socket'
>
> Process finished with exit code 0

###### 源码

```java
public ByteBuffer put(byte x) {
    hb[ix(nextPutIndex())] = x;
    return this;
}
```

```java
final int nextGetIndex() {                          // package-private
    if (position >= limit)
        throw new BufferUnderflowException();
    return position++;
}
```

##### 调用flip()

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
        .put((byte) 3).put((byte) 4).put((byte) 5);
    // 开始读取
    buffer.flip();
    // 打印
    System.out.println(buffer);
}
```

###### 演示

> Connected to the target VM, address: '127.0.0.1:53193', transport: 'socket'
> **java.nio.HeapByteBuffer[pos=0 lim=5 cap=10]**
> Disconnected from the target VM, address: '127.0.0.1:53193', transport: 'socket'
>
> Process finished with exit code 0

###### 源码

```java
public final Buffer flip() {
    limit = position;
    position = 0;
    mark = -1;
    return this;
}
```

##### 读取byte

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
        .put((byte) 3).put((byte) 4).put((byte) 5);
    // 开始读取
    buffer.flip();
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 打印
    System.out.println(buffer);
}
```

###### 演示

> Connected to the target VM, address: '127.0.0.1:53703', transport: 'socket'
> **12**
>
> **java.nio.HeapByteBuffer[pos=2 lim=5 cap=10]**
> Disconnected from the target VM, address: '127.0.0.1:53703', transport: 'socket'
>
> Process finished with exit code 0

###### 源码

```java
public byte get() {
    return hb[ix(nextGetIndex())];
}
```

##### 标记位置

###### 代码

```java
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
        .put((byte) 3).put((byte) 4).put((byte) 5);
    // 开始读取
    buffer.flip();
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 标记
    buffer.mark();
    // 打印
    System.out.println(buffer);
}
```

###### 源码

```java
public final Buffer mark() {
    mark = position;
    return this;
}
```

##### 读取恢复

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
            .put((byte) 3).put((byte) 4).put((byte) 5);
    // 开始读取
    buffer.flip();
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 标记
    buffer.mark();
    // 打印
    System.out.println(buffer);
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 恢复
    buffer.reset();
    // 打印
    System.out.println(buffer);
}
```

###### 演示

> Connected to the target VM, address: '127.0.0.1:54040', transport: 'socket'
> 12**java.nio.HeapByteBuffer[pos=2 lim=5 cap=10]**
> 34**java.nio.HeapByteBuffer[pos=2 lim=5 cap=10]**
> Disconnected from the target VM, address: '127.0.0.1:54040', transport: 'socket'
>
> Process finished with exit code 0

###### 源码

```java
public final Buffer reset() {
    int m = mark;
    if (m < 0)
        throw new InvalidMarkException();
    position = m;
    return this;
}
```

##### 已读释放

###### 代码

```java
@Test
public void test(){
    // 构建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(10);
    // 添加数据
    buffer.put((byte) 1).put((byte) 2)
            .put((byte) 3).put((byte) 4).put((byte) 5);
    // 开始读取
    buffer.flip();
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 标记
    buffer.mark();
    // 打印
    System.out.println(buffer);
    // 读取2个字节
    System.out.print(buffer.get());
    System.out.print(buffer.get());
    // 恢复
    buffer.reset();
    // 释放
    buffer.compact();
    // 打印
    System.out.println(buffer);
}
```

###### 演示

Connected to the target VM, address: '127.0.0.1:54186', transport: 'socket'
12**java.nio.HeapByteBuffer[pos=2 lim=5 cap=10]**
34**java.nio.HeapByteBuffer[pos=3 lim=10 cap=10]**
Disconnected from the target VM, address: '127.0.0.1:54186', transport: 'socket'

Process finished with exit code 0

###### 源码

```java
public ByteBuffer compact() {
    System.arraycopy(hb, ix(position()), hb, ix(0), remaining());
    position(remaining());
    limit(capacity());
    discardMark();
    return this;
}
```

```java
public final int remaining() {
    return limit - position;
}
```

```java
final void discardMark() {                          // package-private
    mark = -1;
}
```



#### 面试题

　　==缓冲区是什么?==

　　缓冲区的本质是一块可读写的内存,。

​	Buffer的核心作用是用来缓冲，缓和冲击。比如你每秒要写100次硬盘，对系统冲击很大，浪费了大量时间在忙着处理开始写和结束写这两件事嘛。用个buffer暂存起来，变成每10秒写一次硬盘，对系统的冲击就很小，写入效率高了。

### 程序演示

![1554977307393](assets/1554977307393.png)



## 聊天工具 

​	该工具仅限控制台使用, 仅作AIO通讯模型在java中的应用演示, **请勿商用**！

### 程序演示

![1554977307393](assets/1554977307393.png)

### 功能实现

#### 客服连接

​	==连通客户端与服务器==



##### 服务端

###### Server

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        // 主线程睡眠1小时
        Thread.sleep(1000*60*60);
    }
}
```

###### ServerHandler

```java
package com.itheima.teach.aio.server;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接受连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:56
 * @description : ServerHandler
 * @modified : -
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {


    /**
     * 有客户端连接触发该方法
     * @param asc
     * @param server
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
        System.out.println("有链接了"+asc);
    }


    /**
     * 客户端连接失败触发该方法
     * @param exc
     * @param server
     */
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel server) {
        System.out.println("客户端连接出错了"+exc.getMessage());
    }
}
```



##### 工具箱

###### Address

```java
package com.itheima.teach.aio.common.constant;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * 地址常量.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:32
 * @description : Address
 * @modified : -
 */
public class Address {
    /**
     * 服务器地址.
     */
    public static final SocketAddress loc = new InetSocketAddress("192.168.193.97", 61616);
}
```



##### 客户端

###### Client

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.constant.Address;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());
    }
}
```

###### ClientHandler

```java
package com.itheima.teach.aio.client;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 客户端连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:40
 * @description : ClientHandler
 * @modified : -
 */
public class ClientHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {


    /**
     * 连接上服务器时触发该方法
     * @param result
     * @param asc
     */
    @Override
    public void completed(Void result, AsynchronousSocketChannel asc) {
        System.out.println("连接成功了"+asc);
    }


    /**
     * 连接失败时触发该方法
     * @param exc
     * @param asc
     */
    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel asc) {
        System.out.println("连接失败了"+exc.getMessage());
    }
}
```



##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:59195', transport: 'socket'
> *有链接了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/192.168.193.97:61616 **remote=/192.168.193.97:59550**]*
> Disconnected from the target VM, address: '127.0.0.1:59195', transport: 'socket'
>
> Process finished with exit code 1



###### 客户端

> Connected to the target VM, address: '127.0.0.1:59548', transport: 'socket'
> *连接成功了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected **local=/0:0:0:0:0:0:0:0:59550** remote=/192.168.193.97:61616]*
> Disconnected from the target VM, address: '127.0.0.1:59548', transport: 'socket'
>
> Process finished with exit code 0

==客户端发起的连接, 服务端已收到。客服连接完毕。==



#### 单向通讯

​	==实现客户端发送消息到服务端==

##### 服务端

###### ServerHandler

```java
/**
 * 有客户端连接触发该方法
 * @param asc
 * @param server
 */
@Override
public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
    System.out.println("有链接了"+asc);
    ByteBuffer buffer = BufferKit.getDef();
    asc.read(buffer, buffer, new ReadHandler());
}
```



###### ReadHandler

```java
package com.itheima.teach.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    /**
     * 有内容读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        System.out.println(new String(buffer.array(), 0, result));
    }

    /**
     * 内容读取失败将触发该方法
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("读取失败");
    }
}
```

##### 工具箱

###### BufferKit

```java
/**
 * 缓冲工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:05
 * @description : BufferKit
 * @modified : -
 */
public class BufferKit {
    /**
     * 获取默认大小的缓冲区.
     *
     * @return the byte buffer
     */
    public static ByteBuffer getDef(){
        return ByteBuffer.allocate(1024);
    }
}
```

##### 客户端

###### Client

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.constant.Address;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());

        // 准备内容
        ByteBuffer buffer = ByteBuffer.wrap("666".getBytes());

        // 写出内容
        asc.write(buffer, buffer, new WriteHandler());
    }
}
```

###### WriteHandler

```java
package com.itheima.teach.aio.client;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

/**
 * 写出处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:47
 * @description : WriteHandler
 * @modified : -
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {


    /**
     * 写出完成触发该方法
     *
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            asc.write(buffer, buffer, this);
        } else {
            System.out.println("写完了");
        }
    }

    /**
     * 写出失败时触发该方法
     *
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("写失败了");
    }
}
```



##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:53252', transport: 'socket'
> 有链接了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/192.168.193.97:61616 remote=/192.168.193.97:53261]
> **666**

###### 客户端

> Connected to the target VM, address: '127.0.0.1:53259', transport: 'socket'
> 连接成功了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/0:0:0:0:0:0:0:0:53261 remote=/192.168.193.97:61616]
> **写完了**
> Disconnected from the target VM, address: '127.0.0.1:53259', transport: 'socket'
>
> Process finished with exit code 0

#### 多端通讯

​	==实现接收多个客户端的连接==

##### 服务端

###### ServerHandler

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.kit.BufferKit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接受连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:56
 * @description : ServerHandler
 * @modified : -
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {


    /**
     * 有客户端连接触发该方法
     * @param asc 客户端
     * @param server 服务端参数
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
        // 不断接收新连接
        server.accept(server, new ServerHandler());
        System.out.println("有链接了"+asc);
        ByteBuffer buffer = BufferKit.getDef();
        asc.read(buffer, buffer, new ReadHandler());
    }


    /**
     * 客户端连接失败触发该方法
     * @param exc
     * @param server
     */
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel server) {
        System.out.println("客户端连接出错了"+exc.getMessage());
    }
}
```

##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:57304', transport: 'socket'
> 有链接了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/192.168.193.97:61616 remote=/192.168.193.97:57311]
> 666
> **有链接了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/192.168.193.97:61616 remote=/192.168.193.97:57319]**
> **666**

###### 客户端x2

> Connected to the target VM, address: '127.0.0.1:57317', transport: 'socket'
> 连接成功了sun.nio.ch.WindowsAsynchronousSocketChannelImpl[connected local=/0:0:0:0:0:0:0:0:57319 remote=/192.168.193.97:61616]
> 写完了
> Disconnected from the target VM, address: '127.0.0.1:57317', transport: 'socket'
>
> Process finished with exit code 0



#### 双向通讯

​	==实现客服互相发送消息==

##### 服务端

###### ServerHandler

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.kit.BufferKit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接受连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:56
 * @description : ServerHandler
 * @modified : -
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {


    /**
     * 有客户端连接触发该方法
     * @param asc 客户端
     * @param server 服务端参数
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
        // 不断接收新连接
        server.accept(server, new ServerHandler());
        // 读取客户端消息
        ByteBuffer buffer = BufferKit.getDef();
        asc.read(buffer, buffer, new ReadHandler(asc));
    }


    /**
     * 客户端连接失败触发该方法
     * @param exc
     * @param server
     */
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel server) {
        System.out.println("客户端连接出错了"+exc.getMessage());
    }
}
```



##### 工具箱

###### WriteHandler

```java
package com.itheima.teach.aio.common.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 写出处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:47
 * @description : WriteHandler
 * @modified : -
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {


    private final AsynchronousSocketChannel asc;

    public WriteHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 写出完成触发该方法
     *
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            asc.write(buffer, buffer, this);
        }
    }

    /**
     * 写出失败时触发该方法
     *
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("写失败了");
    }
}
```

###### ReadHandler

```java
package com.itheima.teach.aio.common.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有内容读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        String text = new String(buffer.array(), 0, result);
        System.out.println(text);
        // 处理信息后回复消息
        ByteBuffer content = ByteBuffer.wrap("收到: ".concat(text).getBytes());
        asc.write(content, content, new WriteHandler());
    }

    /**
     * 内容读取失败将触发该方法
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("读取失败");
    }
}
```

##### 客户端

###### Client

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.handler.WriteHandler;
import com.itheima.teach.aio.common.constant.Address;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());

        // 准备内容
        ByteBuffer buffer = ByteBuffer.wrap("666".getBytes());

        // 写出内容
        asc.write(buffer, buffer, new WriteHandler());

        // 主线程睡眠1小时
        Thread.sleep(1000*60*60);
    }
}
```

###### ClientHandler

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.kit.BufferKit;
import com.itheima.teach.aio.common.handler.ReadHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 客户端连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:40
 * @description : ClientHandler
 * @modified : -
 */
public class ClientHandler implements CompletionHandler<Void, AsynchronousSocketChannel> {


    /**
     * 连接上服务器时触发该方法
     * @param result
     * @param asc
     */
    @Override
    public void completed(Void result, AsynchronousSocketChannel asc) {
        // 连接成功后读取消息
        ByteBuffer buffer = BufferKit.getDef();
        asc.read(buffer, buffer, new ReadHandler(asc));
    }


    /**
     * 连接失败时触发该方法
     * @param exc
     * @param asc
     */
    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel asc) {
        System.out.println("连接失败了"+exc.getMessage());
    }
}
```

##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:60928', transport: 'socket'
> 666

###### 客户端

> Connected to the target VM, address: '127.0.0.1:60936', transport: 'socket'
> 收到: 666



#### 实时通讯

​	==实现随时随刻发送消息==

##### 服务端

###### Server

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.handler.WriteHandler;
import com.itheima.teach.aio.common.kit.Console;
import com.itheima.teach.aio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 获取客户端
            AsynchronousSocketChannel asc = ClientManager.get();
            // 写出内容
            Writer.write(buffer, asc);
        }
    }
}
```

###### ServerHandler

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.handler.ReadHandler;
import com.itheima.teach.aio.common.kit.BufferKit;
import com.itheima.teach.aio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 接受连接处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:56
 * @description : ServerHandler
 * @modified : -
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {



    /**
     * 有客户端连接触发该方法
     * @param asc 客户端
     * @param server 服务端参数
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel server) {
        // 不断接收新连接
        server.accept(server, new ServerHandler());

        // 保存这个客户端
        ClientManager.put(asc);

        // 读取客户端消息
        ByteBuffer buffer = BufferKit.getDef();
        asc.read(buffer, buffer, new ReadHandler(asc));
    }


    /**
     * 客户端连接失败触发该方法
     * @param exc
     * @param server
     */
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel server) {
        System.out.println("客户端连接出错了"+exc.getMessage());
    }
}
```



##### 工具箱

###### Console

```java
package com.itheima.teach.aio.common.kit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 控制台工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:06
 * @description : Console
 * @modified : -
 */
public class Console {

    /**
     * 控制台字符输入流
     */
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
}
```

###### ClientManager

```java
package com.itheima.teach.aio.common.run;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:31
 * @description : ClientManager
 * @modified : -
 */
public class ClientManager {

    /**
     * 客户端
     */
    private static AsynchronousSocketChannel client = null;


    /**
     * 获取客户端
     * @return
     */
    public static AsynchronousSocketChannel get(){
        return client;
    }

    /**
     * 存储客户端
     * @param asc
     * @return
     */
    public static AsynchronousSocketChannel put(AsynchronousSocketChannel asc){
        return client = asc;
    }
}
```

###### Writer

```java
package com.itheima.teach.aio.common.kit;

import com.itheima.teach.aio.common.handler.WriteHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 写出工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 17:19
 * @description : Writer
 * @modified : -
 */
public class Writer {
    /**
     * 写出内容到指定客户端.
     *
     * @param buffer 内容
     * @param asc    客户端
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel asc){
        asc.write(buffer, buffer, new WriteHandler(asc));
    }
}
```

###### ReadHandler

```java
package com.itheima.teach.aio.common.handler;

import com.itheima.teach.aio.common.kit.BufferKit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有内容读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // 不断读取客户端消息
        ByteBuffer next = BufferKit.getDef();
        asc.read(next, next, new ReadHandler(asc));
        // 处理消息
        String text = new String(buffer.array(), 0, result);
        System.out.println(text);
        // 处理信息后回复消息
//        ByteBuffer content = ByteBuffer.wrap("收到: ".concat(text).getBytes());
//        asc.write(content, content, new WriteHandler(asc));
    }

    /**
     * 内容读取失败将触发该方法
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("读取失败");
    }
}
```

##### 客户端

###### Client

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.handler.WriteHandler;
import com.itheima.teach.aio.common.kit.Console;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 写出内容
            Writer.write(buffer, asc);
        }
    }
}
```

##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:65197', transport: 'socket'
> 服务端你好呀
> **喲, 你是客户端吗**
> 是啊是啊, 我是神奇的
> 客
> 户
> 端
> **呵呵, 挺幽默**

###### 客户端

> Connected to the target VM, address: '127.0.0.1:65202', transport: 'socket'
> **服务端你好呀**
> 喲, 你是客户端吗
> **是啊是啊, 我是神奇的**
> **客**
> **户**
> **端**
> 呵呵, 挺幽默



#### 断线重连

​	==实现客户端断线重连==

##### 客户端

###### Client

```java
package com.itheima.teach.aio.client;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.kit.Console;
import com.itheima.teach.aio.common.kit.Writer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:30
 * @description : Client
 * @modified : -
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 获取连接
        AsynchronousSocketChannel asc = getAsc();

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 写出内容
            asc = write(asc, buffer);
        }
    }

    private static AsynchronousSocketChannel getAsc() throws Exception {
        // 打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();
        // 连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());
        // 因为连接是异步的需要等待连接成功
        Thread.sleep(1000);
        return asc;
    }

    private static AsynchronousSocketChannel write(AsynchronousSocketChannel asc, ByteBuffer buffer) throws Exception {
        // 是否连接可用
        if(!asc.isOpen()){
            // 不可用将重新创建
            asc = getAsc();
            System.out.println("重新连接");
        }
        Writer.write(buffer, asc);
        return asc;
    }
}
```

###### ClientManager

```java
package com.itheima.teach.aio.common.run;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 客户端管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:31
 * @description : ClientManager
 * @modified : -
 */
public class ClientManager {

    /**
     * 客户端
     */
    private static AsynchronousSocketChannel client = null;


    /**
     * 获取客户端
     * @return
     */
    public static AsynchronousSocketChannel get(){
        return client;
    }

    /**
     * 存储客户端
     * @param asc
     * @return
     */
    public static AsynchronousSocketChannel put(AsynchronousSocketChannel asc){
        return client = asc;
    }

    /**
     * 关闭客户端
     * @param asc
     * @return
     */
    public static void close(AsynchronousSocketChannel asc){
        if(asc.isOpen()){
            try {
                asc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

##### 工具箱

###### ReadHandler

```java
package com.itheima.teach.aio.common.handler;

import com.itheima.teach.aio.common.kit.BufferKit;
import com.itheima.teach.aio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有内容读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // 不断读取客户端消息
        ByteBuffer next = BufferKit.getDef();
        asc.read(next, next, new ReadHandler(asc));
        // 处理消息
        String text = new String(buffer.array(), 0, result);
        System.out.println(text);
        // 处理信息后回复消息
//        ByteBuffer content = ByteBuffer.wrap("收到: ".concat(text).getBytes());
//        asc.write(content, content, new WriteHandler(asc));
    }

    /**
     * 内容读取失败将触发该方法
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        ClientManager.close(asc);
    }
}
```

##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:50669', transport: 'socket'
> 123
> 223

###### 客户端

> Connected to the target VM, address: '127.0.0.1:50657', transport: 'socket'
> 666
> **123**
> **重新连接**
> **223**



#### 区别发送

​	==实现服务端发送消息到指定客户端==

##### 服务端

###### Server

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.kit.Console;
import com.itheima.teach.aio.common.kit.Writer;
import com.itheima.teach.aio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 获取接收人
            System.out.println("请输入接收人");
            content = Console.reader.readLine();
            // 获取客户端
            AsynchronousSocketChannel asc = ClientManager.get(content);
            // 写出内容
            Writer.write(buffer, asc);
        }
    }
}
```



##### 工具箱

###### Client

```java
package com.itheima.teach.aio.common.bo;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.UUID;

/**
 * 客户端业务模型.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/10 9:02
 * @description : Client
 * @modified : -
 */
public class Client {
    /**
     * 标识
     */
    private String id = UUID.randomUUID().toString();
    /**
     * 别名
     */
    private String alias = id;
    /**
     * 客户端
     */
    private AsynchronousSocketChannel asc;

    public Client(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AsynchronousSocketChannel getAsc() {
        return asc;
    }

    public void setAsc(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
```

###### ClientManager

```java
package com.itheima.teach.aio.common.run;



import com.itheima.teach.aio.common.bo.Client;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 客户端管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:31
 * @description : ClientManager
 * @modified : -
 */
public class ClientManager {

    /**
     * 客户端
     * key: alias
     * value: client
     */
    private static Map<String, Client> clients = new HashMap();


    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get() {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            return it.next().getAsc();
        }
        return null;
    }

    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get(String alias) {
        Client client = clients.get(alias);
        if (client != null) {
            return client.getAsc();
        }
        return null;
    }


    /**
     * 根据asc获取客户端.
     *
     * @param asc the asc
     * @return the client
     */
    public static Client get(AsynchronousSocketChannel asc) {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            Client client = it.next();
            if(asc.equals(client.getAsc())){
                return client;
            }
        }
        return null;
    }

    /**
     * 存储客户端
     *
     * @param asc
     * @return
     */
    public static void put(AsynchronousSocketChannel asc) {
        Client client = new Client(asc);
        clients.put(client.getAlias(), client);
    }

    /**
     * 关闭客户端
     *
     * @param asc
     * @return
     */
    public static void close(AsynchronousSocketChannel asc) {
        if (asc.isOpen()) {
            try {
                asc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

###### Writer

```java
package com.itheima.teach.aio.common.kit;

import com.itheima.teach.aio.common.handler.WriteHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;

/**
 * 写出工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 17:19
 * @description : Writer
 * @modified : -
 */
public class Writer {
    /**
     * 写出内容到指定客户端.
     *
     * @param buffer  内容
     * @param clients 客户端
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel... clients) {
        Arrays.stream(clients)
                .forEach(asc -> {
                    if (asc != null) {
                        ByteBuffer copy = buffer.duplicate();
                        asc.write(copy, copy, new WriteHandler(asc));
                    }
                });
    }
}
```

###### ReadHandler

```java
package com.itheima.teach.aio.common.handler;

import com.itheima.teach.aio.common.bo.Client;
import com.itheima.teach.aio.common.kit.BufferKit;
import com.itheima.teach.aio.common.run.ClientManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 读取处理器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 10:09
 * @description : ReadHandler
 * @modified : -
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private final AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有内容读取将触发该方法
     *
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        // 不断读取客户端消息
        ByteBuffer next = BufferKit.getDef();
        asc.read(next, next, new ReadHandler(asc));
        // 根据asc获取客户端
        Client client = ClientManager.get(asc);
        String alias = client != null ? client.getAlias() : "服务端";
        // 处理消息
        String text = new String(buffer.array(), 0, result);
        System.out.println(alias + ": " + text);
        // 处理信息后回复消息
//        ByteBuffer content = ByteBuffer.wrap("收到: ".concat(text).getBytes());
//        asc.write(content, content, new WriteHandler(asc));
    }

    /**
     * 内容读取失败将触发该方法
     *
     * @param exc
     * @param buffer
     */
    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        ClientManager.close(asc);
    }
}
```





##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:51977', transport: 'socket'
> e21eb0e5-5ff0-40aa-b069-b4413b802099: 服务端辛苦了!
> 38d50e42-644b-46db-ba27-23b6a4439cbc: 嘿嘿
> **99同志幸苦了**
> 请输入接收人
> e21eb0e5-5ff0-40aa-b069-b4413b802099
> **嘿什么嘿**
> 请输入接收人
> 38d50e42-644b-46db-ba27-23b6a4439cbc

###### 客户端bc

> Connected to the target VM, address: '127.0.0.1:51982', transport: 'socket'
> **嘿嘿**
> 服务端: 嘿什么嘿

###### 客户端99

> Connected to the target VM, address: '127.0.0.1:51990', transport: 'socket'
> **服务端辛苦了!**
> 服务端: 99同志幸苦了



#### 群组发送

​	==实现服务端消息群发==

##### 服务端

###### Server

```java
package com.itheima.teach.aio.server;

import com.itheima.teach.aio.common.constant.Address;
import com.itheima.teach.aio.common.kit.Console;
import com.itheima.teach.aio.common.kit.Writer;
import com.itheima.teach.aio.common.run.GroupManager;
import com.itheima.teach.aio.common.bo.Client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.List;

/**
 * 服务器入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/3 17:51
 * @description : Server
 * @modified : -
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();

        // 绑定进程
        server.bind(Address.loc);

        // 接受请求
        server.accept(server, new ServerHandler());

        String content;
        while (true) {
            // 获取用户输入内容
            content = Console.reader.readLine();
            // 封装内容
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            // 获取客户端
            List<Client> clients = GroupManager.get(GroupManager.DEFAULT_ID);
            // 写出内容
            Writer.write(buffer, clients);
        }
    }
}
```

##### 工具箱

###### GroupManager

```java
package com.itheima.teach.aio.common.run;

import com.itheima.teach.aio.common.bo.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 群组管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/10 10:51
 * @description : GroupManager
 * @modified : -
 */
public class GroupManager {

    /**
     * 默认群组编号
     */
    public static final String DEFAULT_ID = "CC";

    /**
     * 群组
     */
    private static final Map<String, List<Client>> groups = new HashMap();


    /**
     * 添加客户端.
     *
     * @param key   the key
     * @param value the value
     */
    public static void put(String key, Client value) {
        List<Client> clients = groups.get(key);
        if (clients == null) {
            clients = new ArrayList();
            groups.put(key, clients);
        }
        clients.add(value);
    }


    /**
     * 获取群组内用户.
     *
     * @param key the key
     * @return the list
     */
    public static List<Client> get(String key) {
        List<Client> clients = groups.get(key);
        if (clients != null) {
            return clients;
        }
        return new ArrayList();
    }
}
```

###### ClientManager

```java
package com.itheima.teach.aio.common.run;



import com.itheima.teach.aio.common.bo.Client;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 客户端管理.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 16:31
 * @description : ClientManager
 * @modified : -
 */
public class ClientManager {

    /**
     * 客户端
     * key: alias
     * value: client
     */
    private static Map<String, Client> clients = new HashMap();


    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get() {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            return it.next().getAsc();
        }
        return null;
    }

    /**
     * 获取1个客户端
     *
     * @return
     */
    public static AsynchronousSocketChannel get(String alias) {
        Client client = clients.get(alias);
        if (client != null) {
            return client.getAsc();
        }
        return null;
    }


    /**
     * 根据asc获取客户端.
     *
     * @param asc the asc
     * @return the client
     */
    public static Client get(AsynchronousSocketChannel asc) {
        Collection<Client> values = clients.values();
        Iterator<Client> it = values.iterator();
        while (it.hasNext()) {
            Client client = it.next();
            if(asc.equals(client.getAsc())){
                return client;
            }
        }
        return null;
    }

    /**
     * 存储客户端
     *
     * @param asc
     * @return
     */
    public static void put(AsynchronousSocketChannel asc) {
        Client client = new Client(asc);
        clients.put(client.getAlias(), client);
        GroupManager.put(GroupManager.DEFAULT_ID, client);
    }

    /**
     * 关闭客户端
     *
     * @param asc
     * @return
     */
    public static void close(AsynchronousSocketChannel asc) {
        if (asc.isOpen()) {
            try {
                asc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

###### Writer

```java
package com.itheima.teach.aio.common.kit;

import com.itheima.teach.aio.common.handler.WriteHandler;
import com.itheima.teach.aio.common.bo.Client;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;
import java.util.Collection;

/**
 * 写出工具.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/9 17:19
 * @description : Writer
 * @modified : -
 */
public class Writer {
    /**
     * 写出内容到指定客户端.
     *
     * @param buffer  内容
     * @param clients 客户端
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel... clients) {
        Arrays.stream(clients)
                .forEach(asc -> {
                    if (asc != null) {
                        ByteBuffer copy = buffer.duplicate();
                        asc.write(copy, copy, new WriteHandler(asc));
                    }
                });
    }

    /**
     * 写出内容到指定客户端.
     *
     * @param buffer  内容
     * @param clients 客户端
     */
    public static void write(ByteBuffer buffer, Collection<Client> clients) {
        clients.forEach(client -> {
            if (client != null && client.getAsc() != null) {
                ByteBuffer copy = buffer.duplicate();
                AsynchronousSocketChannel asc = client.getAsc();
                asc.write(copy, copy, new WriteHandler(asc));
            }
        });
    }
}
```

##### 测试

###### 服务端

> Connected to the target VM, address: '127.0.0.1:53884', transport: 'socket'
> be8305f2-283b-4c22-ba9a-cf78fa17d2f5: 我是客户端1
> f3778d28-8030-4f6d-9a30-fda8aa611c1f: 我是客户端2
> **我知道了。**
> **你们都还好吗?**

###### 客户端1

> Connected to the target VM, address: '127.0.0.1:53896', transport: 'socket'
> **我是客户端1**
> 服务端: 我知道了。
> 服务端: 你们都还好吗?

###### 客户端2

> Connected to the target VM, address: '127.0.0.1:53889', transport: 'socket'
> **我是客户端2**
> 服务端: 我知道了。
> 服务端: 你们都还好吗?



### 未来方向

#### 1. 协议支持

​	当前通讯形式, 不规范不安全。

##### 1.1 Cs

​	==支持C/S模式==

##### 	1.2 HTTP

##### 	1.3 Websocket

​	==支持B/S模式==

#### 2. 多端登陆

#### 3. 离线消息

#### 4. 消息回执

#### 5. 自动回复

#### 6. 群主群管

#### 7. 设置中心

#### 8. 超文消息

## 关于

### 1. 作者 - Jason.lee

### 2. 源码 - [Github](https://github.com/Jason8080/teach/tree/master/aio)

### 2. 交流 - [537950751](https://jq.qq.com/?_wv=1027&k=5vD1Zh6) 