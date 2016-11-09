<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new user</title>
    <spring:url value="/resources/css/first_work_page_forOther.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />

    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
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
            <%--<li><a href="#">Просмотр моей страници</a></li>--%>
            <%--<li><a href="#">Статистика</a></li>--%>
            <%--<li><a href="#">Расчеты</a></li>--%>
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

<div class="container addstudent_form">
    <h1>Add student </h1>
    <h2>${nullFields}</h2>
    <br>
    <form:form action="saveStudent" modelAttribute="student" method="POST">
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>Имя:</label></td>
                <td><form:input path="name" />
                    <form:errors path="name" class="alert alert-danger"></form:errors>
                </td>
            </tr>
            <br>
            <tr>
                <td><label>Фамилия:</label></td>
                <td><form:input path="surname" /></td>
            </tr>
            <br>
            <tr>
                <td><label>Телефон в формате (0xxxxxxxxx):</label></td>
                <td><form:input path="phone" /><form:errors path="phone"  class="alert alert-danger"></form:errors></td>
            </tr>
            <br>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email" /><form:errors path="email" class="alert alert-danger"></form:errors></td>
            </tr>
            <br>
            <tr>
                <td><label>Birthday in format (dd.mm.yyyy):</label></td>
                <td><form:input path="birthday" /><form:errors path="birthday" cssclass="alert alert-danger"></form:errors></td>
            </tr>
            <br>
            <tr>
                <td><label>Возвраст:</label></td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td><label>Post:</label></td>
                <td><form:input path="post" /></td>
            </tr>
            <tr>
                <td><label>Comment:</label></td>
                <td><form:input path="comments"  /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form:form>
</div>

<a href="/registerPerson/showFirstWorkPage">Return to work page</a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>