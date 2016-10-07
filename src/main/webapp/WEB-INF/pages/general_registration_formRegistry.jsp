<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE html>
<html>
<head>

    <title> General Register Form</title>

</head>


<body>


<form:form action="showFirstWorkPage" >

Hello on this page
    <br/><br/>

        <%--First name  <form:input type="text" path="firstName"  />--%>

        <%--Last name  <form:input type="text" path="lastName" />--%>

        <%--You Email  <form:input type="text" path="email" />--%>

        <%--You number  <form:input type="text" path="phone" />--%>

<input type="submit" value="Submit">

</form:form>


        <br><br>

    <br><br>


</body>
</html>