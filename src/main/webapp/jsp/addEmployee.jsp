<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/6/18
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<form action="addEmployee" method="post">
    <fieldset class="form-name">
        <label>First Name</label><input type="text" name="first_name"/><br/>
        <label>Last Name</label><input type="text" name="last_name"/><br/>
        <label>Age</label><input type="text" name="age"/><br/>
        <label>Mail</label><input type="text" name="mail"/><br/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="Add">
</form>
</body>
</html>
