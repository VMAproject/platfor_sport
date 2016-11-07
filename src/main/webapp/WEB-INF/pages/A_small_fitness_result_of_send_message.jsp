<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.10.2016
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Result</title>
</head>
<body>
<center>
    <h3>${message}</h3>
    <br>
    <a href="<c:url value="/registerPerson//showFirstWorkPage"></c:url>">Back to the main</a>
</center>
</body>
</html>
