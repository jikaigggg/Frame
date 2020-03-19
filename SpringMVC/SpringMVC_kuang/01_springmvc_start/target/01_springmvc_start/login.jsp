<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/19
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script>
        function login() {
            $.post({
                url:"${pageContext.request.contextPath}/login",
                data:{"name":$("#username").val()},
                success:function (data) {
                    alert(data);
                }
            })
        }
    </script>
</head>
<body>
<form action="">
    用户名：<input type="text" id="username"  onblur="login()"/>
    密码：<input type="text" id="password"  onblur="login()"/>

</form>
</body>
</html>
