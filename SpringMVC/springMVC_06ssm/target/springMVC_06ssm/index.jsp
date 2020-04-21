<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3><a href="/account/findAll">测试查询</a></h3>

<h3>测试保存</h3>
<form action="account/saveAccount" method="post">
    姓名：<input type="text" name="name"> <br>
    金额：<input type="text" name="money"> <br>
    <input type="submit" value="保存">
</form>
</body>
</html>
