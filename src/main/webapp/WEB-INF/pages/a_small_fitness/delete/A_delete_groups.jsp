<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
    <spring:url value="/resources/css/first_work_page_forOther.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
</head>
<body>
<header class="header">
    <div class="container">
        <h1>World Sport Platform BF 1.0</h1>
        <h2>
            <small>Movement breeds success!</small>
        </h2>
    </div>
</header>
<!-- /HEADER -->
<!-- NAVIGATION -->
<nav class="page-navigation">
    <div class="container">
        <ul>
            <li><a href="#">Главная</a></li>
            <li><a href="/group/ShowGroupPage">Группы</a></li>
            <li><a href="/registerPerson/showFirstWorkPage">Кабинет</a></li>
        </ul>


    </div>
</nav>


<div class="container addgroup_form">
    <h1>Delete group</h1>
    <br>
    <form:form action="deleteGroups"  method="get">

        <li> Group
            <ul>
                <c:forEach items="${groupList}" var="groups">

                    <c:if test="${groups.main==true}">
                <li>${groups.name}  <input type="checkbox" class="idGroup", name="idGroup" value="${groups.id}"></li>
                </c:if>
                </c:forEach>
            </ul>
        </li>

        <li> Trainers Group
            <ul>
                <c:forEach items="${groupList}" var="groups">

                    <c:if test="${groups.main!=true}">
                        <li>${groups.name} <input type="checkbox" class="idGroup", name="idGroup" value="${groups.id}"></li>
                    </c:if>
                </c:forEach>
            </ul>
        </li>

                <td><input type="submit" value="Delete" class="delete" /></td>

    </form:form>
</div>

<a href="/group//ShowGroupPage">Return tu group</a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>
