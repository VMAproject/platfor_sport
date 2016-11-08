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

        <!-- LOGIN FORM -->
        <form action="#" class="login">
            <input type="text" placeholder="Login" required>
            <input type="password" placeholder="Password" required>
            <input type="submit" value="Sign In">
        </form>
        <!-- /LOGIN FORM -->
    </div>
</nav>


<div class="container addgroup_form">
    <h1>Update category at trainers of group</h1>
    <br>
    <form:form action="updateCategory" modelAttribute="category" method="POST">
        <form:hidden path="id" />
        <table>
            <tbody>
            <tr>
                <td><label>Введите новое название категории:</label></td>
                <td><form:input path="name" /></td>
            </tr>

            <tr>
            <select name="option">
                <option value="">выберите категорию</option>
                <c:forEach items="${categoryList}" var="category">
                    <%--<c:if test="${category.nameTraine!=null}">--%>
                    <%--<option value="${groups.id}">--%>
                        <%--<c:out value="${groups.nameTraine}"/>--%>
                    <%--</option>--%>
                    <%--</c:if>--%>
                    <option value="${category.id}">
                    <c:choose>
                        <c:when test="${category.main==true}">
                            <c:out value="${category.name}"/>
                        </c:when>
                        <c:when test="${category.main!=true}">
                            <c:out value="${category.name}"/>
                        </c:when>
                    </c:choose>
                    </option>
                </c:forEach>
            </select>
                </tr>
            <tr>
            <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form:form>
</div>

<a href="/group//ShowGroupPage">Return tu group</a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>
