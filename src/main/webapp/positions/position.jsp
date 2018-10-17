<%--
  Created by IntelliJ IDEA.
  User: Przemysław
  Date: 17.10.2018
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Position</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <jsp:include page="../employees/menu.jsp">
        <jsp:param name="activeTab" value="position"/>
    </jsp:include>
    <h2>${h2Text}</h2>
    <form class="form-horizontal" action="/position/save" method="POST">
        <c:if test="${not empty position.positionId}">
            <div class="form-group">
                <label class="control-label col-sm-2">Id: ${position.positionId}</label>
            </div>
        </c:if>
        <div class="form-group">
            <label class="control-label col-sm-2" for="positionName">Position:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="positionName" placeholder="Enter position name" name="positionName" value="${position.positionName}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="salary">Salary:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="salary" placeholder="Enter salary" name="salary" value="${position.salary}">
            </div>
        </div>
        <input type="hidden" name="positionId" value="${position.positionId}"/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
