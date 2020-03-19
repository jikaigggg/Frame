<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script>
        function a(){
            $.post({
                url:"${pageContext.request.contextPath}/a1",
                data:{"name":$("#username").val()},
                success:function (data) {
                    alert(data);
                }
                })
        }

    </script>
</head>
<body>
<form action="/add/" method="post">
    <input type="text" name="a">
    <input type="text" name="b">
    <input type="submit">
</form>

<div>
    <%--失去焦点的时候，发起一个请求（携带参数）到后台--%>
用户名：<input type="text" id="username" onblur="a()" />

</div>


</body>
</html>