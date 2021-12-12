<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 29.11.2021
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/my-app/login" method="post">
    <tr>Invalid Data</tr>
    <table>
        <tr>
            <td>Your username:</td>
            <td><input type="text" name="username" /></td>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>
        <tr>
            <td></td>
            <td><input type="submit" value="login" /></td>
        </tr>
    </table>
</form>
</body>
</html>
