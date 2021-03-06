<%--
  Created by IntelliJ IDEA.
  User: Przemysław
  Date: 16.10.2018
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee App</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>

            <li <c:if test="${param.activeTab == 'employees'}">
                class="active"
            </c:if>
            >
                <a href="/employees">Employees Page</a>
            </li>

            <c:choose>
            <c:when test="${param.activeTab == 'employee'}">
            <li class="active">
                </c:when>
                <c:otherwise>
            <li>
                </c:otherwise>
                </c:choose>
                <a href="/employee/add">Add Employee</a>
            </li>
            <c:choose>
            <c:when test="${param.activeTab == 'positions'}">
            <li class="active">
                </c:when>
                <c:otherwise>
            <li>
                </c:otherwise>
                </c:choose>
                <a href="/positions">Positions</a>
            </li>
            <c:choose>
            <c:when test="${param.activeTab == 'position'}">
            <li class="active">
                </c:when>
                <c:otherwise>
            <li>
                </c:otherwise>
                </c:choose>
                <a href="/position/add">Add Position</a>
            </li>
        </ul>
    </div>
</nav>
