<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/16/2021
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="com.company.util.Object" %>
<html>
<head>
    <title>Rating rage for teachers</title>
</head>
<body>
<label>Teacher rating page</label>
<% ArrayList<Object> objectNames = (ArrayList) request.getAttribute("objectNames");%>
<form>
    <select name ="objects">
        <option value="-1">Select object</option>

            <% for (int i = 0; i < objectNames.size(); i++) { %>
        <%Object object = objectNames.get(i);%>
        <option value="<%=object.getId()%>"><%=object.getName()%></option>
            <% } %>

    </select>
</form>
</body>
</html>
