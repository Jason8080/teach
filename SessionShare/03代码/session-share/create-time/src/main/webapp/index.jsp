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
欢迎光临
<script>
    document.writeln(location.port);
    document.writeln("<br/>");
    <%
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            response.getWriter().println(c.getName() + ": " + c.getValue() + "<br/>");
        }
    %>
</script>!
</body>
</html>
