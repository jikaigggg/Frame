<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/1
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<h3>查询了所有</h3>
<c:forEach items="${all}" var="accout">
    ${accout.name}
</c:forEach>
</body>
</html>
