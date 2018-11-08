<%--@elvariable id="department_id" type="java"--%>
<%--@elvariable id="id" type="java"--%>
<%--@elvariable id="firstName" type="java"--%>
<%--@elvariable id="lastName" type="java"--%>
<%--@elvariable id="age" type="java"--%>
<%--@elvariable id="mail" type="java"--%>
<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/6/18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="ru">
<head>
    <title>Update Employee</title>
</head>
<body>
<form action="updateEmployee" method="post">
    <fieldset class="form-name">
        <label for="firstName">First Name</label><input id="firstName" type="text" name="first_name" value="${firstName}"/><br/>
        <label for="lastName">Last Name</label><input id="lastName" type="text" name="last_name" value="${lastName}"/><br/>
        <label for="age">Age</label><input id="age" type="text" name="age" value="${age}"/><br/>
        <label for="mail">Mail</label><input id="mail" type="text" name="mail" value="${mail}"/><br/>
        <input type="hidden" name="department_id" value="${department_id}"/><br/>
        <input type="hidden" name="id" value="${id}"/><br/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="UPDATE">
</form>
</body>
</html>