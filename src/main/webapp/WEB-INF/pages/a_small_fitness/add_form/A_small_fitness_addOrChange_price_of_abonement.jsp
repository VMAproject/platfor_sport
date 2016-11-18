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
    <h1>Add new  or change price</h1>
    <br>
    <form:form action="saveOrChangeAbonement" modelAttribute="price" method="POST">
        <form:hidden path="id" />
        <table>
            <tbody>
            <tr>
                <td><label>single price:</label></td>
                <td><form:input path="priceSingle" /></td>
            </tr>


            <tr>
                <td><label>half month:</label></td>
                <td><form:input path="priceMonthHalf" /></td>
            </tr>

            <tr>
                <td><label>month price:</label></td>
                <td><form:input path="priceMonth" /></td>
            </tr>

            <tr>
                <td><label>Year price:</label></td>
                <td><form:input path="priceYear" /></td>
            </tr>

            <tr>
                <td><label>Individual price:</label></td>
                <td><form:input path="priceIndividual" /></td>
            </tr>

            <tr>
                <td><label>Another price:</label></td>
                <td><form:input path="priceOther" /></td>
            </tr>

                <td><label></label></td>
                <td><input type="submit" value="Save Price" class="save" /></td>
            <td><input type="submit" value="Delete abonement" class="delete" /></td>
            </tr>

            </tbody>
        </table>
    </form:form>
</div>

<a href="/group//ShowGroupPage">Return to group</a>
<footer class="footer">
    <div class="container">

    </div>
</footer>
</body>
</html>