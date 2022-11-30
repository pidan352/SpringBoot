<%--
  Created by IntelliJ IDEA.
  User: 15524
  Date: 2022/11/15
  Time: 19:04
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
    <c:forEach var="name" items="${list}">
        ${name}<br>
    </c:forEach>
</body>
</html>
