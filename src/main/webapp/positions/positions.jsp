<%--
  Created by IntelliJ IDEA.
  User: Przemysław
  Date: 17.10.2018
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Positions</title>
</head>
<body>
<div class="container">
    <jsp:include page="../employees/menu.jsp">
        <jsp:param name="activeTab" value="positions"/>
    </jsp:include>
    <h2>Positions list</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Position</th>
            <th>Salary</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${positions}" var="position">
            <tr>
                <td>${position.positionId}</td>
                <td>${position.positionName}</td>
                <td>${position.salary}</td>
                <td><a href="/position?id=${position.positionId}">Edit</a></td>
                <td><a href="/position/delete?id=${position.positionId}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
