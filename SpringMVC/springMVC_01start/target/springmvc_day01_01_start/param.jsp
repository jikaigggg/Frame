<%--
  Created by IntelliJ IDEA.
  User: jikaigg
  Date: 2020/2/27
  Time: 9:42
  To change this template use File | Settings | File Templates.
  请求参数绑定
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>params</title>
</head>
<body>

<%--<a href="/param/testparam">请求参数绑定</a>--%>
<%--<form action="/param/saveaccount" method="post">
    姓名：<input type="text" name="username"> <br>
    密码：<input type="text" name="password"> <br>
    金额：<input type="text" name="money"> <br>
    用户姓名：<input type="text" name="user.name"> <br>
    用户年龄：<input type="text" name="user.age"> <br>
    <input type="submit" value="提交">
</form>--%>

<form action="/param/saveaccount" method="post">
    姓名：<input type="text" name="username"> <br>
    密码：<input type="text" name="password"> <br>
    金额：<input type="text" name="money"> <br>
    用户姓名：<input type="text" name="luser[0].name"> <br>
    用户年龄：<input type="text" name="luser[0].age"> <br>
    用户姓名：<input type="text" name="muser['aa'].name"> <br>
    用户年龄：<input type="text" name="muser['aa'].age"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
