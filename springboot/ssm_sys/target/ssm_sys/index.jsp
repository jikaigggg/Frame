<%--
  Created by IntelliJ IDEA.
  User: jikaigg
  Date: 2020/3/11
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<![endif]-->
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
    function login() {
        $.ajax({
            url: "user/login",
            data: {"username": $("#empName").val(), "password": $("#empEmail").val()},
            success: function () {
                if (retult == 1) {
                    window.location.href = "success.jsp"
                } else {
                    alert("用户不存在")
                }
            }
        })
    }
</script>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="#" method="post" id="loginform">
    用户名：<input type="text" id="empName"> <br>
    密码： <input type="text" id="empEmail"> <br>
    <a href="javascript:login()" id="btn">提交</a>
</form>


</body>
</html>
