<%--
  Created by IntelliJ IDEA.
  User: Przemysław
  Date: 16.10.2018
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="menu.jsp">
        <jsp:param name="activeTab" value="employee"/>
    </jsp:include>
    <h2>${h2Text}</h2>
    <form class="form-horizontal" action="/employee/save" method="POST">
        <c:if test="${not empty employee.id}">
            <div class="form-group">
                <label class="control-label col-sm-2">Id: ${employee.id}</label>
            </div>
        </c:if>
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name"
                       value="${employee.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="surname">Surname:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="surname" placeholder="Enter surname" name="surname"
                       value="${employee.surname}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="positionName">Position:</label>
            <div class="col-sm-10">
                <select class="form-control" name="positionName" required id="position">
                    <c:choose>
                        <c:when test="${not empty employee.positionName}">
                            <option value="${employee.positionName}"
                                    data-number="${employee.salary}">${employee.positionName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="">Choose...</option>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach items="${positions}" var="position">
                        <c:if test="${employee.positionName != position.positionName}">
                            <option value="${position.positionName}" data-number="${position.salary}"
                                    data-id="${position.positionId}">${position.positionName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>

        <input type="hidden" class="form-control" id="positionName" placeholder="Enter position" name="positionName"
               value="${employee.positionName}" disabled>

        <div class="form-group">
            <label class="control-label col-sm-2" for="salary">Salary:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="salary" placeholder="Enter salary" name="salary"
                       value="${employee.salary}" disabled>
            </div>
        </div>
        <input type="hidden" name="id" value="${employee.id}"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>