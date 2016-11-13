<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> First Work Page</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <spring:url value="/resources/script/js.js" var="js" />
    <%--<spring:url value="/resources/css/first_work_page_for_cabinet.css" var="style" />--%>
    <spring:url value="/resources/css/normalize.css" var="normalize" />
    <spring:url value="/resources/css/tableStyle.css" var="tableStyle" />
    <spring:url value="/resources/css/page_for_group_menu.css" var="navigate" />


    <script src="<c:url value="/resources/script/js.js" />"></script>
    <link rel="stylesheet" type="text/css" href="${style}" >
    <link rel="stylesheet" type="text/css" href="${normalize}" >
    <link rel="stylesheet" type="text/css" href="${tableStyle}" >
    <link rel="stylesheet" type="text/css" href="${navigate}" >

</head>


<body>

<SCRIPT language="javascript">
    $(function(){
        // add multiple select / deselect functionality
        $("#selectall").click(function () {
            $('.case').attr('checked', this.checked);
        });
        // if all checkbox are selected, check the selectall checkbox
        // and viceversa
        $(".case").click(function(){
            if($(".case").length == $(".case:checked").length) {
                $("#selectall").attr("checked", "checked");
            } else {
                $("#selectall").removeAttr("checked");
            }
        });
    });
</SCRIPT>
<!-- HEADER -->
<!-- NAVIGATION -->


<div class="navigate">
    <ul class="navbar cf">

        <li><a href="/registerPerson/showFirstWorkPage">Cabinet</a></li>
        <li><a href="">Groups</a>
            <%--//create controls item for updeting group--%>
            <ul>
                <li><a href="#">controls</a>
                    <ul>
                        <li><a href="/group//showFormForUpdate">Update</a></li>
                        <li><a href="/group//showFormForDelete">Delete</a></li>
                        <li><a href="/group//showFormForAddGroup">new group</a></li>
                    </ul>
                </li>
                <li><a href="#">Category</a>
                    <%--//create controls item for updeting categoty of group--%>
                    <ul>
                        <li><a href="#">controls</a>
                            <ul>
                                <li><a href="/group//showFormForUpdateCategory">Update</a></li>
                                <li><a href="#">Delete</a></li>
                                <li><a href="/group//showFormForAddCategory">new</a></li>
                            </ul>
                        </li>
                        <%--//create and show new category--%>
                        <c:forEach items="${categoryList}" var="category">
                            <c:if test="${category.main==true}">
                                <li><a href="#"><c:out value="${category.name}"/></a>
                                    <ul>
                                            <%--//show groups if they location in one of the category--%>
                                        <c:forEach items="${groupsList}" var="groups">
                                            <%--//create links for click--%>
                                            <c:url var="takeGroupId" value="/group//takeIdGroup" >
                                                <c:param name="groupId" value="${groups.id}"/>
                                            </c:url>

                                            <c:if test="${groups.categoryGroup.id==category.id}">
                                                <li> <a href="${takeGroupId}"> <c:out value="${groups.name}"/></a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
                <li><a href="/group//showFormAddOrChangePriceAbonement">Abonement Price</a></li>
                <%--// Empty li--%>
                <li><a href="#">.....</a></li>
                <%--//show new creating groups--%>
                <c:forEach items="${groupsList}" var="groups">
                    <%--// check, if groups don't belongs some of category, the show it--%>
                    <c:if test="${groups.categoryGroup.id==null && groups.main==true}">
                        <%--//create links for click--%>
                        <c:url var="takeGroupId" value="/group//takeIdGroup" >
                            <c:param name="groupId" value="${groups.id}"/>
                        </c:url>

                        <li><a href="${takeGroupId}"><c:out value="${groups.name}"/></a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </li>
        <%--//close groups menu, and show first level menu items--%>


        <%--//add this functionality to the Instructors Groups--%>
        <li><a href="#">Instructors Groups</a>
            <ul>
                <li><a href="#">controls</a>
                    <ul>
                        <li><a href="/group//showFormForUpdate">Update</a></li>
                        <li><a href="/group//showFormForDelete">Delete</a></li>
                        <li><a href="/group//AddGroupToInstructorsForm">new group</a></li>
                    </ul>
                </li>
                <li><a href="#">Category</a>
                    <%--//create controls item for updeting categoty of group--%>
                    <ul>
                        <li><a href="#">controls</a>
                            <ul>
                                <li><a href="/group//showFormForUpdateCategory">Update</a></li>
                                <li><a href="#">Delete</a></li>
                                <li><a href="/group//showFormForAddCategoryTrainers">new trainers</a></li>
                            </ul>
                        </li>
                        <%--//create and show new category--%>
                        <c:forEach items="${categoryList}" var="category">
                            <c:if test="${category.main!=true}">
                                <li><a href="#"><c:out value="${category.name}"/></a>
                                    <ul>
                                            <%--//show groups if they location in one of the category--%>
                                        <c:forEach items="${groupsList}" var="groups">
                                            <%--//create links for click--%>
                                            <c:url var="takeGroupId" value="/group//takeIdGroup" >
                                                <c:param name="groupId" value="${groups.id}"/>
                                            </c:url>

                                            <c:if test="${groups.categoryGroup.id.equals(category.id)}">
                                                <li> <a href="${takeGroupId}"> <c:out value="${groups.name}"/></a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
                <%--// Empty li--%>
                <li><a href="#">.....</a></li>
                <%--//show new creating groups--%>
                <c:forEach items="${groupsList}" var="groups">
                    <%--// check, if groups don't belongs some of category, the show it--%>
                    <c:if test="${groups.categoryGroup.id==null && groups.main!=true}">
                        <%--//create links for click--%>
                        <c:url var="takeGroupId" value="/group//takeIdGroup" >
                            <c:param name="groupId" value="${groups.id}"/>
                        </c:url>

                        <li><a href="${takeGroupId}"><c:out value="${groups.name}"/></a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </li>
        <%--//close groups menu, and show first level menu items--%>

        <li><a href="#">Statistic</a></li>

        <li><a href="#">Finance</a></li>

        <li>
            <c:set value="${chooseGroup}" var="group"/>
            <a href="#">You in ${group.name} group</a>
        </li>
         <li><a href="#">${currentUser.username}  ${currentUser.email}</a></li>
        <li id="out"><a href='<c:url value="/logout"></c:url>' class="btn btn-default btn-flat">Sign OUT</a></li>
    </ul>


</div>


<div>
    <c:set value="${chooseTrainerGroup}" var="groupTrainer"/>
    <c:set value="${chooseGroup}" var="group"/>

    <c:choose>
        <c:when test="${groupTrainer}!=null">
            <h4>You in ${groupTrainer} group </h4>
        </c:when>
        <c:when test="${groupTrainer}==null">
            <h4>You in ${group} group </h4>
        </c:when>
    </c:choose>

</div>

<!-- MAIN SECTION -->
<main>



    <div class="work_form">

        <div class="button_navigation_form">

            <div class=" fins_form">

                <form action="find" method="get">
                    <label for="surname"><spring:message code="firstWorkPage.findStudent.surname"></spring:message> </label>
                    <input type="text" id="surname" name="surname">
                    <input type="submit" value="найти">
                </form>

            </div>

            <div class="sort_form" >

                <form method="get" action="/registerPerson//sort">
                    <select name="option">
                        <option disabled selected><spring:message code="sort.selectSortType"></spring:message> </option>
                        <option value="ageAfterSixteen"><spring:message code="sort.sortByAgeAfter"></spring:message> </option>
                        <option value="ageBeforeSixteen"><spring:message code="sort.sortByAgeBefore"></spring:message> </option>
                        <option value="getUnknownStudent"><spring:message code="sort.getStudentByOnlyUnknownStudent"></spring:message> </option>
                        <option value="allStudent"><spring:message code="sort.sortByAll"></spring:message> </option>
                    </select>
                    <input type="submit" value="<spring:message code="Sort"></spring:message> ">
                </form>

            </div>

        </div>


        <%--Table form--%>
        <div class="table form">

            <form method="post" action="act">
                <input type="hidden" id="txt" name="">
                <input type="button" value="Добавить"
                       onclick="window.location.href='addStudentToGroupForm'; return false;" class="add-button"
                />
                <input type="submit" name="delete" value="удалить">
                <input type="submit" name="send_email" value="send email" class="add-button"
                />
                <input type="button" value="Отправить смс">
                <%--<input type="button" value="отправить письмо">--%>
        </div>
    </div>
    <br/><br/>
    <br/><br/>
    <br/><br/>

    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">
        <thead>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Телефон</th>
        <th>почта</th>
        <th>абонемент</th>
        <th>Разовое посещение</th>
        <th>Дата начала Абонемента</th>
        <th>Дата окончания Абонементадата</th>
        <th>Статус оплаты</th>
        <th></th>
        <th>Блок<input type="radio"></th>
        <th><input type="checkbox" id="selectall"></th>
       <th>Редактировать поле</th>
        </thead>
        <tbody>

        <c:forEach items="${students}" var="student">
            <tr align="center">
                <td>${student.name}</td>
                <td align="left">${student.surname}</td>
                <td>${student.phone}</td>
                <td>${student.email}</td>

                <td>

                    <select name="selectedPrice">
                        <option value="0">abonement price</option>
                        <c:forEach items="${priceList}" var="prices">
                            <%--<c:choose>--%>
                            <c:if test="${prices.priceMonth!=0}">
                            <option value="prices"><c:out value="${prices.priceMonth}"/></option>
                            </c:if>
                                <c:if test="${prices.priceMonth!=0}">
                                    <option value="prices"><c:out value="${prices.priceMonthHalf}"/></option>
                                </c:if>
                                <c:if test="${prices.priceMonth!=0}">
                                    <option value="prices"><c:out value="${prices.priceSingle}"/></option>
                                </c:if>
                        <%--</c:choose>--%>
                        </c:forEach>
                    </select>

                </td>

                <td></td>
                <td>
                   <input type="date" name="selectedStartDate">
                </td>

                <td>
                    <input type="date" name="selectedFinisfDate">
                </td>
                <td>
                    <select name="selectedCode">
                        <option value="1">Олачено</option>
                        <option value="2">Не оплачено</option>
                        <option value="3">Долг</option>
                    </select>

                </td>
                <td><input type="submit" name="set" value="OK"></td>
                <td > <input type="radio"></td>
                <td><input type="checkbox" class="case", name="case" value="${student.id}"></td>
                <td>
                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/registerPerson/showFormForUpdate" >
                        <c:param name="studentId" value="${student.id}"/>
                    </c:url>

                    <!-- display the update link -->
                    <a href="${updateLink}">Редактировать</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <table border="3"  width="100%"   cellpadding="4" cellpacing="3">
        <th>Count of participants</th>
        <th>Count of abonements</th>
        <th>Sum of abonements</th>
        <th>Users with debt</th>
        <tr align="center">
            <td>${countOfRecords}</td>
            <td>${countOfAbonements}</td>
            <td>${withoutName}</td>
            <td>${withDebt}</td>

        </tr>


    </table>




    </form>


    <br><br>
    <br><br>

    </div>

</main>


<!-- FOOTER -->
<footer class="footer">
    <div class="container">

    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>