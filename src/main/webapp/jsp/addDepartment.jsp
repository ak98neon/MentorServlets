<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/4/18
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="ru">
<head>
    <title>AddDepartment</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="addDepartment" method="post">
    <fieldset class="form-name">
        <label for="name">Name</label><input id="name" type="text" name="name"/><br/>
    </fieldset>
    <input type="submit" class="btn btn-success" value="Add">
</form>
</body>
<%request.setCharacterEncoding("UTF-8");%>
</html>