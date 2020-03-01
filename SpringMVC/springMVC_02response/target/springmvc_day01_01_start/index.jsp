<%--
  Created by IntelliJ IDEA.
  User: jikaigg
  Date: 2020/2/28
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>response</title>
    <script src="/js/jquery.min.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"jikai","password":"yao","age":"15"}',
                    dataType:"json",
                    type:"POST",
                    success:function (data) {
                        //data指的服务器响应的json数据
                        alert(data);
                        alert(data.name);
                        alert(data.password);
                        alert(data.age);

                    }
                })
            });
        });
    </script>
</head>
<body>
<a href="user/testString">TestString</a> <br>
<a href="user/testVoid">TestVoid</a> <br>
<a href="user/testModelAndView">TestModelAndView</a> <br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a> <br>

<button id="btn">发送ajax请求</button>
</body>
</html>
