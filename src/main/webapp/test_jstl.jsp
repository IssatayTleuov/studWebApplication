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
    <td>Mark</td>
    <td>Student Id</td>
    <td>Teacher Id</td>
    <td>Object Id</td>
    <td>Mark_Type Id</td>
    <td>Time</td>
    </thead>
<c:forEach var="rating" items="${ratings}">
    <tr>
        <td>${rating.id}</td>
        <td>${rating.mark}</td>
        <td>${rating.studentId}</td>
        <td>${rating.teacherId}</td>
        <td>${rating.objectId}</td>
        <td>${rating.markTypeId}</td>
        <td>${rating.time}</td>
    </tr>
    <br>
</c:forEach>
</table>
</div>
</body>
</html>
