<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Choose Register</title>
    <meta charset="utf-8">

    <spring:url value="/resources/css/chooseRegisterFormRegistry.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />



    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">




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
            <li><a href="#">Home</a></li>
            <li><a href="/showPage">GO-GO-GO</a></li>
            <li><a href="#">Contacts</a></li>
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

  <h3>
    Let's get started!
    First, tell us what you're looking for.
  </h3>

    <table class="table">
        <thead>

        </thead>
        <tbody>
        <tr class="active">
            <td>I want to register like a trainer</td>
            <td><a href="/home"> REGISTER </a> </td>
        </tr>
        <tr class="success">
            <td>I want to register as a fitness center</td>
            <td><a href="/registerPerson/registerFitnessCenter">REGISTER</a></td>
        </tr>
        <tr class="info">
            <td>I want to register as a guest</td>
            <td><a href="/registerPerson/registerGuest"> REGISTER </a> </td>
        </tr>
        <tr class="warning">
            <td>I want to register as a studio or sports section</td>
            <td><a href="/registerPerson/registerSportsSection"> REGISTER </a></td>
        </tr>

        </tbody>
    </table>


    <%--<div class="container-first">--%>


                    <%--<h3></h3>--%>


                  <%--<h3>  <a href="/registerPerson/general_registration_form"> REGISTER</a></h3>--%>



                    <%--<h3>I want to register  like a finnes Center</h3>--%>

                            <%--<button ><a href="/registerPerson/showForm">REGISTER</a></button>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>



    <%--</div>--%>

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