<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artemkudrya
  Date: 11/4/18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html lang="ru">
<head>
    <title>List Department</title>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@include file = "../css/listDepartmentStyle.css"%>
    </style>
</head>
<body>
<div class="wrapper">
    <div class="header">List Department</div>
    <div class="departments">
        <button class="btn-add"><a href="${pageContext.request.contextPath}/addDepartment">Add Department</a></button>
        <table class="list">
            <tr class="header-table">
                <th>#</th>
                <th>Name Department</th>
                <th>Update</th>
                <th>Delete</th>
                <th>List Employees</th>
            </tr>
            <%--@elvariable id="departments" type="java.util.List"--%>
            <c:forEach items="${departments}" var="oneItem">
                <tr>
                    <td>${oneItem.id}</td>
                    <td>${oneItem.name}</td>
                    <td><a class="btn btn-update" href="${pageContext.request.contextPath}/updateDepartment?id=${oneItem.id}">Update</a></td>
                    <td><a class="btn btn-delete" href="${pageContext.request.contextPath}/deleteDepartment?id=${oneItem.id}">Delete</a></td>
                    <td><a class="btn btn-list-employees" href="${pageContext.request.contextPath}/listEmployee?id=${oneItem.id}">List Employees</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<%request.setCharacterEncoding("UTF-8");%>
</html>