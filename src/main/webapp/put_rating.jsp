<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.database.ObjectDao" %><%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/16/2021
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rating rage for teachers</title>
</head>
<body>
<label>Teacher rating page</label>
<center>
    <select>
        <option>Select object</option>
        <%
            ObjectDao objectDao = new ObjectDao();
            ArrayList<String> objectNames;
            objectNames = objectDao.getObjectNames();

            for(String obj : objectNames) {
//                don't work
                %>
        <option><% obj.toString();
            }
    %>

    </select>
</center>
</body>
</html>
