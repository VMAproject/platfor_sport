<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %><!DOCTYPE html><html><head>    <title> First Work Page</title>    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>    <spring:url value="/resources/script/js.js" var="js" />    <spring:url value="/resources/css/first_work_page.css" var="style" />    <spring:url value="/resources/css/normalize.css" var="normalize" />    <spring:url value="/resources/css/tableStyle.css" var="tableStyle" />    <script src="<c:url value="/resources/script/js.js" />"></script>    <link rel="stylesheet" type="text/css" href="${style}" >    <link rel="stylesheet" type="text/css" href="${normalize}" >    <link rel="stylesheet" type="text/css" href="${tableStyle}" >    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">    <script  type="text/javascript" src="/resources/script/bootstrap.min.js"></script></head><body><SCRIPT language="javascript">    $.noConflict();    $(function(){        // add multiple select / deselect functionality        $("#selectall").click(function () {            $('.case').attr('checked', this.checked);        });        // if all checkbox are selected, check the selectall checkbox        // and viceversa        $(".case").click(function(){            if($(".case").length == $(".case:checked").length) {                $("#selectall").attr("checked", "checked");            } else {                $("#selectall").removeAttr("checked");            }        });    });</SCRIPT><!-- HEADER --><!-- NAVIGATION --><div class="menu-navigation">        <ul id="navbar">            <li><a href="#">Main</a></li>            <li><a href="/registerPerson/showFirstWorkPage">Cabinet</a></li>            <li><a href="#">Groups</a>                <ul id="group">                    <li><a href="/group/ShowGroupPage">overall</a></li>                    <%--<li id="create"><a href="javascript://" onclick="Add();return false;">Create</a>  </li>--%>                    <li id="create"   ><a href="/group//showFormForAddGroup">Create</a>  </li>                    <li><a href="#">Delete</a> </li>                    <li><a href="#">Categoty</a> </li>                    <li><a href="#">Update</a> </li>                    <c:forEach items="${groupList}" var="groups">                        <c:url var="takeGroupId" value="/group//takeIdGroup" >                            <c:param name="groupId" value="${groups.id}"/>                        </c:url>                        <c:if test="${groups.name!=null}">                            <li >                                    <%--<a href="/group//ShowGroupPage" >--%>                                <a href="${takeGroupId}" >                                    <c:out value="${groups.name}" />                                </a>                            </li>                        </c:if>                    </c:forEach>                </ul>    </li>            <li><a href="#">instructors group</a>            <ul>                <li><a href="#">Create</a>  </li>                <li><a href="#">Categoty</a></li>                <li><a href="#">Delete</a> </li>                <li><a href="#">Update</a> </li>            </ul>            </li>            <li><a href="#">Statistics</a></li>            <li><a href="#">Finance</a></li>           <li id="out"><a href="">Out</a></li>        </ul>        </div><!-- MAIN SECTION --><main>    <div class="work_form"><div><div>    <input type="button" value="Add1">    <input type="button" value="Add2">    <input type="button" value="Add3">    <input type="button" value="Add4">    </div>    <br/><br/>    <br/><br/><form action="find" method="post">    <select name="option">        <option value="name"><spring:message code="firstWorkPage.findStudent.name"></spring:message> </option>        <option value="surname"><spring:message code="firstWorkPage.findStudent.surname"></spring:message></option>        <option value="email"><spring:message code="firstWorkPage.findStudent.email"></spring:message></option>        <option value="phone"><spring:message code="firstWorkPage.findStudent.phone"></spring:message></option>    </select>    <input type="text" id="data" name="data">    <input type="submit" value="найти"></form>    </div>       <div class="sort_form" >       <form method="get" action="/registerPerson//sort">           <select name="option">        <option disabled selected><spring:message code="sort.selectSortType"></spring:message> </option>        <option value="ageAfterSixteen"><spring:message code="sort.sortByAgeAfter"></spring:message> </option>        <option value="ageBeforeSixteen"><spring:message code="sort.sortByAgeBefore"></spring:message> </option>        <option value="getUnknownStudent"><spring:message code="sort.getStudentByOnlyUnknownStudent"></spring:message> </option>        <option value="allStudent"><spring:message code="sort.sortByAll"></spring:message> </option>           </select>    <input type="submit" value="<spring:message code="Sort"></spring:message> ">        </form>    </div>      </div>    <%--Table form--%>    <div class="table form">    <form method="get" action="delete"><input type="hidden" id="txt" name="">        <input type="button" value="Добавить"               onclick="window.location.href='showFormForAdd'; return false;" class="add-button"        />        <input type="submit" name="deletee" value="удалить">        <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal">            Send email        </button>        <input type="button" value="Отправить смс">        <%--<input type="button" value="отправить письмо">--%></div></div>    <br/><br/>    <br/><br/>    <br/><br/>    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">        <th>Имя</th>        <th>Фамилия</th>        <th>Телефон</th>        <th>почта</th>        <th>дата рождения</th>        <th>Возвраст</th>        <th>должность</th>        <th>комментарий</th>        <th><input type="checkbox" id="selectall"></th>        <c:forEach items="${students}" var="student">            <tr align="center">                <td>${student.name}</td>                <td align="left">${student.surname}</td>                <td>${student.phone}</td>                <td>${student.email}</td>                <td>${student.strBirthday}</td>                <td>${student.age}</td>                <td></td>                <td></td>                <td><input type="checkbox" class="case", name="case" value="${student.id}"></td>                <td align="left"></td>                <td>                    <!-- construct an "update" link with customer id -->                    <c:url var="updateLink" value="/registerPerson/showFormForUpdate" >                        <c:param name="studentId" value="${student.id}"/>                    </c:url>                    <!-- display the update link -->                    <a href="${updateLink}">Редактировать</a>                </td>            </tr>        </c:forEach>    </table>    <!-- Modal -->    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">        <div class="modal-dialog" role="document">            <div class="modal-content">                <div class="modal-header">                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>                    <h4 class="modal-title" id="myModalLabel">Choose type of email you'd like to send</h4>                </div>                <div class="modal-body">                        <input type="submit" name="send_email" value="Send simple email" class="btn btn-primary"/>                         <input type="submit" name="send_complex_email" value="Send complex email" class="btn btn-primary">                </div>                <div class="modal-footer">                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>                </div>            </div>        </div>    </div></form><br><br><br><br></div></main><!-- FOOTER --><footer class="footer">    <div class="container">    </div></footer><!-- /FOOTER --></body></html>