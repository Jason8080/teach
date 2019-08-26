<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2019/8/21
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
欢迎光临: ${empty user?"<a href='/'>去登录</a>":user} !<br/>
服务器: <span id="port"></span>
</body>
<script>
    let host = document.location.host;
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "http://" + host + "/getPort.do", true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            let pe = document.getElementById("port");
            pe.innerHTML = xmlHttp.responseText;
        }
    }
</script>
</html>
