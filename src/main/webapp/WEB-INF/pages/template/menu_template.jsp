<%--
  Created by IntelliJ IDEA.
  User: Mixas
  Date: 24.11.2016
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Template menu</title>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    <spring:url value="/resources/script/js.js" var="js"/>
    <%--<spring:url value="/resources/css/first_work_page_for_cabinet.css" var="style" />--%>
    <spring:url value="/resources/css/page_for_group_menu.css" var="style"/>
    <spring:url value="/resources/css/normalize.css" var="normalize"/>
    <spring:url value="/resources/css/tableStyle.css" var="tableStyle"/>

    <script src="<c:url value="/resources/script/js.js" />"></script>
    <link rel="stylesheet" type="text/css" href="${style}">
    <link rel="stylesheet" type="text/css" href="${normalize}">
    <link rel="stylesheet" type="text/css" href="${tableStyle}">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script type="text/javascript" src="/resources/script/bootstrap.min.js"></script>

</head>
<body>

<SCRIPT language="javascript">
    $.noConflict();
    $(function () {

        // add multiple select / deselect functionality
        $("#selectall").click(function () {
            $('.case').attr('checked', this.checked);
        });

        // if all checkbox are selected, check the selectall checkbox
        // and viceversa
        $(".case").click(function () {

            if ($(".case").length == $(".case:checked").length) {
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
                                            <c:url var="takeGroupId" value="/group//takeIdGroup">
                                                <c:param name="groupId" value="${groups.id}"/>
                                            </c:url>

                                            <c:if test="${groups.categoryGroup.id==category.id}">
                                                <li><a href="${takeGroupId}"> <c:out value="${groups.name}"/></a></li>
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
                    <c:if test="${groups.categoryGroup.id==null && groups.main==true}">
                        <%--//create links for click--%>
                        <c:url var="takeGroupId" value="/group//takeIdGroup">
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
                                            <c:url var="takeGroupId" value="/group//takeIdGroup">
                                                <c:param name="groupId" value="${groups.id}"/>
                                            </c:url>

                                            <c:if test="${groups.categoryGroup.id.equals(category.id)}">
                                                <li><a href="${takeGroupId}"> <c:out value="${groups.name}"/></a></li>
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
                        <c:url var="takeGroupId" value="/group//takeIdGroup">
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
            <h4>You in your cabinet</h4>
        </li>

        <li><a href="#">${currentUser.username} ${currentUser.email}</a></li>
        <li id="out"><a href='<c:url value="/logout"></c:url>' class="btn btn-default btn-flat">Sign OUT</a></li>
    </ul>


</div>




</body>
</html>
