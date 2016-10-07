
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html>
<head>
    <title>Star Page</title>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <spring:url value="/resources/script/js.js" var="js" />
    <spring:url value="/resources/css/style.css" var="style" />
    <spring:url value="/resources/css/normalize.css" var="normalize" />
    <spring:url value="/resources/images/profile.jpg" var="image" />
    <spring:url value="/resources/vide/motiv.mp4" var="motiv" />
    <spring:url value="/resources/vide/movie.mp4" var="movie" />

    <script src="<c:url value="/resources/script/js.js" />"></script>

    <%--<script src="${js}"></script>--%> <!--another example-->

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
            <li><a href="#">Главная</a></li>
            <li><a href="/showChooseRegisterForm">Старт</a></li>
            <li><a href="#">Контакты</a></li>
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




    <div class="container-first">
        <h2 class="collection-title">Управляй мечтой</h2>
        <div class="collections-first">
            <div class="collection-item-outer-first" >
                <div class="collection-item-first">
                    <input type="Button" value="Jkfkf jfdddfd" class="button-navigator" id="heals" >
                    <input type="Button" value="dsdddsds" class="button-navigator" id="shop">
                    <input type="Button" value="dsdsd, dsdsdsds" class="button-navigator" id="work">
                </div>
            </div>


            <div class="collection-item-outer-first">
                <div class="collection-item-first">
                    <div class="video-motiv">
                        <video controls>

                            <source src="<c:url value="/resources/video/motiv.mp4" />" type="video/mp4">
                        </video>
                        <div class="collection-text">
                            <h3>List Element Item</h3>
                            <p>Some text wos here
                                aaasasasa
                                sasasasasadd
                            </p>
                            <button onclick="showText(this)">Read More...</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">


        <!-- Colections video block -->
        <h2 class="collection-title">Video Collection </h2>
        <div class="collections">
            <div class="collection-item-outer">
                <div class="collection-item">
                    <video controls >
                        <source src="<c:url value="/resources/video/movie.mp4" />" type="video/mp4">
                    </video>
                    <div class="collection-text">
                        <h3>List Element Item</h3>
                        <p>Some text wos here
                            aaasasasa
                            sasasasasadd
                        </p>
                        <button onclick="showText(this)">Read More...</button>
                    </div>
                </div>
            </div>

            <div class="collection-item-outer">
                <div class="collection-item">
                    <video controls>
                        <source src="<c:url value="/resources/video/movie.mp4" />" type="video/mp4">
                    </video>
                    <div class="collection-text">
                        <h3>List Element Item</h3>
                        <p>Some text wos here
                            aaasasasa
                            sasasasasadd
                        </p>
                        <button>Read More...</button>
                    </div>
                </div>
            </div>


            <div class="collection-item-outer">
                <div class="collection-item">
                    <video controls>
                        <source src="<c:url value="/resources/video/movie.mp4" />" type="video/mp4">
                    </video>
                    <div class="collection-text">
                        <h3>List Element Item</h3>
                        <p>Some text wos here
                            aaasasasa
                            sasasasasadd
                        </p>
                        <button >Read More...</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
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