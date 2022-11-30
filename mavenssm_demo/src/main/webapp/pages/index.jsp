<%--
  Created by IntelliJ IDEA.
  User: 15524
  Date: 2022/11/14
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<c:forEach items="${list}" var="name">
    <li>${name}</li>
</c:forEach>
</ul>
</body>
</html>
