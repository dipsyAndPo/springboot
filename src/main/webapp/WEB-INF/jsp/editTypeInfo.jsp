<%--
  Created by IntelliJ IDEA.
  User: 宇通
  Date: 2018/11/4
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin:0px auto; width:500px">

    <form action="updateTypeInfo" method="post">

        name: <input name="typeName" value="${typeInfo.typeName}"> <br>

        <input name="typeId" type="hidden" value="${typeInfo.typeId}">
        <button type="submit">提交</button>

    </form>
</div>
</body>
</html>
