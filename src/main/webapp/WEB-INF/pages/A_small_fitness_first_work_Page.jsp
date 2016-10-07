<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<div>
<div>
    <input type="button" value="Add1">
    <input type="button" value="Add2">
    <input type="button" value="Add3">
    <input type="button" value="Add4">
    </div>
    <br/><br/>
    <br/><br/>

    <input type="button" value="найти">
    <input type="button" value="редактировать">
<div style="font-weight: bold;
	width: 130px;
	padding: 5px 10px;
	margin-top: 30px;
	margin-left: 800px;
background: #cccccc; "  >




    <input type="button" value="добавить">
    <input type="button" value="удалить">
    <input type="button" value="Отправить смс">
    <input type="button" value="отправить письмо">
 </div>
    </div>
    <br/><br/>
    <br/><br/>
    <br/><br/>

<form:form>



    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">
        <tr>
            <th colspan="7">
                <h3><br>Общие данные</h3>
            </th>
        </tr>
        <th>Имя</th>
        <th>Фамилия</th>
            <th>Телефон</th>
            <th>почта</th>
            <th>дата рождения</th>
            <th>должность</th>
            <th>комментарий</th>
           <th><input type="checkbox"></th>
            <tr>
                <td>Alex</td>
                <td>Linov</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>checbox</td>
            </tr>

    </table>
    
    
    
    
    
    
</form:form>


<br><br>

<br><br>


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