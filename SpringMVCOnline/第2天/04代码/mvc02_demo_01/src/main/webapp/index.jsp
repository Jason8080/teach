<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2020/2/29
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页|欢迎光临</title>
</head>
<body>
    <h3>演示: 限制请求</h3>
    <form method="post" action="/list2.do">
        <input type="text" name="id" value="1">
        <input type="text" name="name" value="Jason1">
        <input type="submit"/>
    </form>
    <h3>演示: POST乱码</h3>
    <form method="post" action="/list3.do">
        <input type="text" name="id" value="3">
        <input type="text" name="name" value="小李3">
        <input type="submit"/>
    </form>
    <h3>演示: 嵌套对象</h3>
    <form method="post" action="/list4.do">
        <input type="text" name="id" value="4">
        <input type="text" name="money" value="10.0">
        <input type="text" name="user.id" value="4">
        <input type="text" name="user.username" value="Jason4">
<%--        <input type="text" name="user.birthday" value="2020-02-29">--%>
        <input type="submit"/>
    </form>
</body>
</html>
