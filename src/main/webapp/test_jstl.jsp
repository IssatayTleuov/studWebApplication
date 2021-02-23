<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/22/2021
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Test JSTL</title>
</head>
<body>
<div align="center">
<table border="1">
    <thead>
    <td>Id</td>
    <td>Student Name</td>
    <td>Mark/Monday</td>
    <td>Mark/Tuesday</td>
    <td>Mark/Wednesday</td>
    <td>Mark/Thursday</td>
    <td>Mark/Friday</td>
    </thead>
<c:forEach var="rating" items="${ratingList}" varStatus="theCount">
    <tr>
        <td>${rating.id}</td>
        <td>${studentList[theCount.index]  }</td>
        <td>${rating.mark}</td>
    </tr>
    <br>
</c:forEach>
</table>
</div>
</body>
</html>
