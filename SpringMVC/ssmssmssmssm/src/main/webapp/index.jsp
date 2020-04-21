<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div>
    <a href="${pageContext.request.contextPath}/book/allbook" class="btn btn-primary btn-lg" style="text-align: center">进入书籍页面</a>

    <div>
        <form action="user/login" method="post">
            用户名：<input type="text" id="username">

        </form>
    </div>
</div>
</body>
</html>
