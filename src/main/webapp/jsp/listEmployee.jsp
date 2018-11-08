<%--@elvariable id="depId" type="java"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>List Employee</title>
    <meta charset="UTF-8">
    <style type="text/css">
        <%@include file = "../css/listEmployeeStyle.css"%>
    </style>
</head>
<body>
<div class="wrapper">
    <div class="header">List Employee</div>
    <div class="departments">
        <button class="btn-add"><a href="${pageContext.request.contextPath}/addEmployee?id=${depId}">Add Employee</a></button>
        <table class="list">
            <tr class="header-table">
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Mail</th>
                <th>Date of create</th>
                <th>Department ID</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <%--@elvariable id="employees" type="java.util.List"--%>
            <c:forEach items="${employees}" var="oneItem">
                <tr>
                    <td>${oneItem.id}</td>
                    <td>${oneItem.firstName}</td>
                    <td>${oneItem.lastName}</td>
                    <td>${oneItem.age}</td>
                    <td>${oneItem.mail}</td>
                    <td>${oneItem.dateOfCreation}</td>
                    <td>${oneItem.departmentId}</td>
                    <td><a class="btn btn-update" href="${pageContext.request.contextPath}/updateEmployee?id=${oneItem.id}&depId=${depId}">Update</a></td>
                    <td><a class="btn btn-delete" href="${pageContext.request.contextPath}/deleteEmployee?id=${oneItem.id}&depId=${depId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>