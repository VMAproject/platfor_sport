<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in Login</title>
    <link href="<c:url value='/resources/css/login.css' />" rel="stylesheet">
    </link>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/funtions/login.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/funtions/validation.js' />"></script>
</head>

<body>
<div class="login-page">
    <div class="form">
        <font color="red">
				<span style="align: center">
					<c:if test="${not empty param['error']}">
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                    </c:if>
				</span>
        </font>
        <form class="register-form" id="registerForm" action="#" method="post">
            <input type="text" placeholder="Login" id="username" autocomplete="off" onkeyup="checkLogin(this.value)"/>
            <span id="e_login" style="display: none; color: #c00;">Логин введён неправильно. Минимум 5 символов</span></p>
            <input type="password" placeholder="Password" id="password" onkeyup="checkPassword(this.value)"/>
            <span id="e_password" style="display: none; color: #c00;">Пароль введён неправильно. Минимум 5 символов</span></p>
            <input type="email" placeholder="email address" id="email" autocomplete="off" onkeyup="checkEmail(this.value)"/>
            <span id="e_email" style="display: none; color: #c00;">Проверте правильность ввода данных </span></p>


            <input type="text" placeholder="You Name" id="name" onkeyup="checkName(this.value)"/>
            <span id="e_name" style="display: none; color: #c00;">Имя дожно быть не меньше 3х символов</span></p>
            <input type="text" placeholder="You Surname" id="surname" onkeyup="checkSurname(this.value)">
            <span id="e_surname" style="display: none; color: #c00;">Фамилия дожна быть не меньше 3х символов</span></p>
            <input type="date" placeholder="You Birthday" id="birthday">

            <input type="text" placeholder="You phone" id="phone" onkeyup="checkPhone(this.value)">
            <span id="e_phone"></span>

            <input type="text" placeholder="You City" id="city">
            <input type="text" placeholder="You Country" id="country">
            <input type="text" placeholder="You District" id="district">

            <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
            <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
            <button>create</button>
            <p class="message">Already registered? <a href="#" onclick="toggle_visibility(); return false;"
                                                      class="message">Sign In</a></p>
        </form>
        <form class="login-form" action="<c:url value='/login' />" method="post">
            <input type="text" name="username" placeholder="username" autocomplete="off"
                   onkeyup="checkLoginA(this.value)"/>
            <span id="a_login"
                  style="display: none; color: #c00;">Логин введён неправильно. Минимум 5 символов</span></p>
            <input type="password" name="password" placeholder="password" onkeyup="checkPasswordA(this.value)"/>
            <span id="a_password"
                  style="display: none; color: #c00;">Пароль введён неправильно. Минимум 5 символов</span></p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button>login</button>
            <p class="message">Not registered? <a href="#" onclick="toggle_visibility(); return false;" class="message">Create
                an account</a></p>
        </form>
    </div>
</div>

</body>
</html>