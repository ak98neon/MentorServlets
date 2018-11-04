<%@ page import="com.ak98neon.model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/4/18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Department</title>
    <meta charset="UTF-8">
</head>
<body>
    <div class="wrapper">
        <div class="header">List Department</div>
        <div class="Departments">
            <ui>
                <%
                    List<Department> list = (List<Department>) request.getAttribute("departments");
                    if (list != null && !list.isEmpty()) {
                        list.forEach((dep) -> System.out.println("<li>" + dep.getId() + " " + dep.getName() + "</li>"));
                    } else out.println("<p>There are no departments yet!</p>");
                %>
            </ui>
        </div>
    </div>
</body>
</html>
