<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send mail</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script  type="text/javascript" src="/resources/script/bootstrap.min.js"></script>
</head>

<body>
<form:form  action="sendComplexMail" method="post">



                    <input name="email" placeholder="Enter email you want to send from" class="form-control"  type="text">


        <!-- Password input-->


                    <input type="password" name="password" placeholder="Enter password from your email" class="form-control" >

<table>
    <%--<th>пон</th>--%>
    <%--<th>вт</th>--%>
    <%--<th>ср</th>--%>
    <%--<th>чв</th>--%>
    <%--<th>пн</th>--%>
    <%--<th>суб</th>--%>
    <%--<th>воск</th>--%>
        <c:forEach items="${date}" var="n">
        <th> ${n}  <input type="checkbox" class="case", name="case" value="${n}"></th>

        </c:forEach>

    <tr>
        <%--<c:forEach items="${date}" var="n">--%>
        <%--<td> ${n}  <input type="checkbox" class="case", name="case" value=""></td>--%>

        <%--</c:forEach>--%>




    </tr>
</table>



        <!-- Text input-->

                    <input name="topic" placeholder="Topic of the letter" class="form-control" type="text">

        <!-- Text area -->


                    <textarea class="form-control" name="body" placeholder="Enter message here"></textarea>

                    <input type="submit" value="save and sand">


</form:form>

<br><br>


</body>

</html>