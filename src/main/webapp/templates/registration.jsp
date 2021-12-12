<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 30.11.2021
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/my-app/registration" method="post">
    <table>
        <tr>
            <td>Your username:</td>
            <td><input type="text" name="username" /></td>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>
        <tr>
            <td>Age:</td>
            <td><input type="number" name="age" /></td>
        <tr>
            <td>Weight:</td>
            <td><input type="number" step="0.01" name="weight" /></td>
        <tr>
            <td>Height:</td>
            <td><input type="number"  step="0.1" name="height" /></td>
        <tr>
            <td>Lifestyle:</td>
            <td><input type="number"  name="lifestyle" /></td>
        <tr>
            <td></td>
            <td><input type="submit" value="login" /></td>
        </tr>
    </table>
</form>
</body>
</html>
