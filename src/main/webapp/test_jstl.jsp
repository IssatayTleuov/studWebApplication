<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/22/2021
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Test JSTL</title>
</head>
<body>
<form action="/test_jstl" method="post" style="float: left">
<div style="float: left">
    <select name="objects" id="objects">
        <option value="-1">Select object</option>
        <c:forEach var="object"  items="${objects}">
            <option value="${object.id}">${object.name}</option>
        </c:forEach>
    </select>
</div>
<div style="float: left">
    <select name="mark_type" id="mark_type">
        <option value="-1">Select type of mark</option>
        <c:forEach var="markType"  items="${markTypes}">
            <option value="${markType.id}"}>${markType.name}</option>
        </c:forEach>
    </select>
</div>
<div style="float: left">
    <select name="date" id="date">
        <option <%--value="-1"--%>>Select date</option>
        <c:forEach var="date"  items="${dates}" varStatus="loop">
            <option <%--value="${loop.index}"--%>>${date}</option>
        </c:forEach>
    </select>
</div>
    <button type="submit">Show marks</button>
</form>
</body><form action="/test_jstl" method="get">
    <table align="center" border="1">
        <thead>
        <td>Id</td>
        <td>Student Name</td>
        <td>Mark</td>
        </thead>
        <c:forEach var="rating" items="${ratings}" varStatus="count">
            <tr>
                <td>${rating.id}</td>
                <td>${students[count.index]}</td>
                <td>${rating.mark}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</html>
