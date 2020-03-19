<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addbook" method="post">
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" class="form-control" id="bookName" name="bookName" placeholder="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量</label>
            <input type="text" class="form-control" id="bookCounts" name="bookCounts" placeholder="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍说明</label>
            <input type="text" class="form-control" id="detail" name="detail" placeholder="detail" required>
        </div>

        <input type="submit" value="添加" class="form-control">
    </form>
</div>