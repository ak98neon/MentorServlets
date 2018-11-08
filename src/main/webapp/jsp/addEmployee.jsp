<%--@elvariable id="id" type="java"--%>
<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/6/18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <title>Add Employee</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="addEmployee" method="post">
    <fieldset class="form-name">
        <label for="firstName">First Name</label><input id="firstName" type="text" name="first_name"/><br/>
        <label for="lastName">Last Name</label><input id="lastName" type="text" name="last_name"/><br/>
        <label for="age">Age</label><input id="age" type="text" name="age"/><br/>
        <label for="mail">Mail</label><input id="mail" type="text" name="mail"/><br/>
        <input type="hidden" name="depId" value="${id}"/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="Add">
</form>
</body>
</html>