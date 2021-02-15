<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/15/2021
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher account creating page</title>
</head>
<body>
<form action="teach_create_account" method="post">
    <p><tr>
        <td>Name</td>
        <td><input type="text" name="name"></td>
    </tr></p>
    <p><tr>
        <td>Surname</td>
        <td><input type="text" name="surname"></td>
    </tr></p>
    <p><tr>
        <td>Phone</td>
        <td><input type="text" name="phoneNumber"></td>
    </tr></p>
    <p><tr>
        <td>Object</td>
        <td><input type="text" name="objectId"></td>
    </tr></p>
    <p><tr>
        <td>Faculty</td>
        <td><input type="text" name="facultyId"></td>
    </tr></p>
    <p><tr>
        <td>Login</td>
        <td><input type="text" name="login"></td>
    </tr></p>
    <p><tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
    </tr></p>
    <p><tr>
        <td></td>
        <td><input type="submit" name="Register"></td>
    </tr></p>
    </table>
</form>
</body>
</html>
