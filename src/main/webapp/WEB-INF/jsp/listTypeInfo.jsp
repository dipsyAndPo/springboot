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
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            /*将post method 改变为delete*/
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("#fromdelete").attr("action",href).submit();
                return false;
            });
        });
    </script>
</head>
<body>
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
            <td><a href="TypeInfos/${c.typeId}">编辑</a></td>
            <td><a class="delete" href="TypeInfos/${c.typeId}">删除</a></td>
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
<br><br><br>
<form action="TypeInfos" method="post" align="center">
    <h3>添加</h3>
    name: <input name="typeName" >
    <button type="submit">提交</button>
</form>


<form id="fromdelete" action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>
</body>
</html>
