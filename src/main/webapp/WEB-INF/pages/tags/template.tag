<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="locale"%>

<!DOCTYPE html>
<html>
<head>

    <title> First Work Page</title>

    <spring:url value="/resources/css/first_work_page.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />



    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >

</head>


<body>
<!-- HEADER -->
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
            <li><a href="/">Главная</a></li>
            <li><a href="">Группы</a></li>
            <li><a href="#">Кабинет</a></li>
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
<!-- /NAVIGATION -->
<!-- MAIN SECTION -->
<main>
<jsp:body />
</main>
<!-- /MAIN SECTION -->
<!-- FOOTER -->
<footer class="footer">
    <div class="container">

    </div>
</footer>
<!-- /FOOTER -->

</body>
</html>
</html>
