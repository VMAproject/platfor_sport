<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
<title>Choose Register</title>

    <spring:url value="/resources/css/chooseRegisterFormRegistry.css" var="style" />
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
            <li><a href="/">Home</a></li>
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

    <div class="container-first">

        <div class="collections-first">
            <div class="collection-item-outer-first" >
                <div class="collection-item-first">

                    <h3>I want to register like a traine</h3>

                    <br/><br/>


                  <h3>  <a href="/registerPerson/general_registration_form"> REGISTER</a></h3>
                    <br/><br/>
                </div>
            </div>

            <div class="collection-item-outer-first" >
                <div class="collection-item-first">
                    <p><pre>

                |
                |
                |
                |
                OR
                |
                |
                |
</pre>
                            </p>


</div>
</div>

            <div class="collection-item-outer-first">

                <div class="collection-item-first">

                    <h3>I want to register  like a finnes Center</h3>


                            <br/><br/>


                            <button ><a href="/registerPerson/showForm">REGISTER</a></button>



                </div>
            </div>
        </div>



    </div>
    <br/><br/><br/><br/> <br/><br/> <br/><br/> <br/><br/>
    <br/><br/><br/><br/>
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