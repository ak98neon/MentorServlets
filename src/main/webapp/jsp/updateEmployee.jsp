<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/6/18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Update Employee</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="updateEmployee" method="post">
    <fieldset class="form-name">
        <label>First Name</label><input type="text" name="first_name" value="${firstName}"/><br/>
        <label>Last Name</label><input type="text" name="last_name" value="${lastName}"/><br/>
        <label>Age</label><input type="text" name="age" value="${age}"/><br/>
        <label>Mail</label><input type="text" name="mail" value="${mail}"/><br/>
        <input type="hidden" name="department_id" value="${department_id}"/><br/>
        <input type="hidden" name="id" value="${id}"/><br/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="UPDATE">
</form>
</body>
</html>