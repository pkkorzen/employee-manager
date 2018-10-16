<%--
  Created by IntelliJ IDEA.
  User: Przemysław
  Date: 16.10.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Employees</title>
</head>
<body>
<div class="container">
  <jsp:include page="./employees/menu.jsp">
    <jsp:param name="activeTab" value="home"/>
  </jsp:include>
  <h2>Employees App</h2>
</div>
</body>
</html>
