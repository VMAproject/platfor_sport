<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send mail</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script  type="text/javascript" src="/resources/script/bootstrap.min.js"></script>
</head>

<body>
<form:form class="well form-horizontal" action="sendMail" method="post">


    <fieldset>

        <!-- Form Name -->
        <legend>You trying to sent email to this students:
            <c:forEach items="${students}" var="students">
                ${students.name} ${students.surname};
            </c:forEach></legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Your E-Mail</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                    <input name="email" placeholder="Enter email you want to send from" class="form-control"  type="text">
                </div>
            </div>
        </div>

        <!-- Password input-->

        <div class="form-group">
            <label class="col-md-4 control-label" >Password</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="password" name="password" placeholder="Enter password from your email" class="form-control" >
                </div>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Title</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                    <input name="topic" placeholder="Topic of the letter" class="form-control" type="text">
                </div>
            </div>
        </div>
        <!-- Text area -->

        <div class="form-group">
            <label class="col-md-4 control-label">Text</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                    <textarea class="form-control" name="body" placeholder="Enter message here"></textarea>
                </div>
            </div>
        </div>

        <!-- Success message -->
        <div class="alert alert-success" role="alert" id="success_message"> <i class="glyphicon glyphicon-thumbs-up"></i> </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning" >Send <span class="fa fa-paper-plane" aria-hidden="true"></span></button>
            </div>
        </div>

    </fieldset>
</form:form>

<br><br>


</body>

</html>