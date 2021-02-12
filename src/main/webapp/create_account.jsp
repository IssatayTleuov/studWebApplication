<%--
  Created by IntelliJ IDEA.
  User: TB
  Date: 2/12/2021
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create account</title>
</head>
<body>
<form action="create_account" method="post">
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
        <td>Course</td>
        <td><input type="number" name="course"></td>
    </tr></p>
    <p><tr>
        <td>Faculty</td>
        <td><input type="number" name="facultyId"></td>
    </tr></p>
<%--    <p><tr>--%>
<%--        <td>User</td>--%>
<%--        <td><input type="number" name="userId"></td>--%>
<%--    </tr></p>--%>
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
        <td><input type="submit" name="Login"></td>
    </tr></p>
    </table>
</form>
</body>
</html>
