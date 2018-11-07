<%--
  Created by IntelliJ IDEA.
  User: 宇通
  Date: 2018/10/31
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="toPage?url=insertTypeInfo">添加</a>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${page.list}" var="c" varStatus="st">
        <tr>
            <td>${c.typeId}</td>
            <td>${c.typeName}</td>
            <td><a href="getTypeInfo?typeId=${c.typeId}">编辑</a></td>
            <td><a href="deleteTypeInfo?typeId=${c.typeId}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<br>

<div align="center">
    当前第${page.pageNum}页，共${page.pages}页
    <a href="?start=1">首页</a>
    <a href="?start=${page.pageNum-1}">上一页</a>
    <a href="?start=${page.pageNum+1}">下一页</a>
    <a href="?start=${page.pages}">末页</a>
</div>
</body>
</html>
