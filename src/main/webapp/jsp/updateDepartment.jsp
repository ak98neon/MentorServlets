<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/5/18
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Department</title>
</head>
<body>
<h1>Update Department</h1>
<form action="updateDepartment" method="post">
    <fieldset class="form-name">
        <label>Name</label><input type="text" name="name" value="${name}"/><br/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="UPDATE">
</form>
</body>
</html>