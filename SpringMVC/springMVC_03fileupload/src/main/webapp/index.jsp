<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/29
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>文件上传</h3>

<form action="/user/fileupload1" method="post" enctype="multipart/form-data">
    选择文件：
    <input type="file" name="upload"> <br>
    <input type="submit" value="上传文件1">
</form>

<form action="/user/fileupload2" method="post" enctype="multipart/form-data">
    选择文件：
    <input type="file" name="upload"> <br>
    <input type="submit" value="上传文件2">
</form>
</body>
</html>
