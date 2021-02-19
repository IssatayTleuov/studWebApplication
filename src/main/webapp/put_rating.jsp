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
<%@ page import="com.company.util.MarkType" %>
<% ArrayList<Object> objectNames = (ArrayList) request.getAttribute("objectNames");%>
<% ArrayList<MarkType> markTypes = (ArrayList)request.getAttribute("markTypes");%>
<%int objectId = (int)request.getAttribute("objectId");%>
<html>
<head>
    <title>Rating rage for teachers</title>
</head>
<body>
<label>Teacher rating page</label>
<br><br><br>
<form style="float: left">
    <select name ="objects">
        <option value="-1">Select object</option>
            <% for (int i = 0; i < objectNames.size(); i++) { %>
        <%Object object = objectNames.get(i);%>
        <%if (object.getId() == objectId) {%>
        <option value="<%=object.getId()%>"><%=object.getName()%></option>
            <% } %>
        <% } %>
    </select>
    &ensp;
</form>
<form style="float: left">
    &ensp;
    <select name = "markTypes">
        <option value="-1">Select type of mark</option>
        <%for (int i = 0; i <markTypes.size(); i++) {%>
                <%MarkType markType = markTypes.get(i);%>
        <option value="<%markType.getId();%>"><%=markType.getName()%></option>
            <%}%>
    </select>
</form>
</body>
</html>
