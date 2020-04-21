<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/19
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>ajax异步获取数据</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.post({
                    url: "${pageContext.request.contextPath}/a2",
                    success: function (data) {
                        var html = "";
                        for (let i = 0; i < data.length; i++) {
                            html += "<tr><td>" + data[i].name + "</td>" + "<td>" + data[i].age + "</td>" + "<td>" + data[i].gender + "</td></tr>"
                        }
                        $("#context").html(html)
                    }
                })

            })
        })
    </script>

</head>
<body>

<input type="button" value="加载数据" id="btn"/>

<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tr id="context">

    </tr>
</table>
</body>
</html>
