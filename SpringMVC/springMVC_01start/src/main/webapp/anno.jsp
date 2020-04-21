<%--
  Created by IntelliJ IDEA.
  User: jikaigg
  Date: 2020/2/28
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/anno/requestparam" methods="GET">paramTest</a></h3>

<form action="/anno/requestbody" method="post">
    姓名：<input type="text" name="username"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<h3><a href="/anno/pathVariable/10" methods="GET">pathVariable</a></h3>

</body>
</html>
