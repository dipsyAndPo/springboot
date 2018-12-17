<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<br>

<div align="center">
    当前第<span id="dangqian"></span>页，共<span id="yigong"></span>页
    <button type="button" onclick="select(0)">首页</button>
    <button type="button" onclick="select(0,1)">上一页</button>
    <button type="button" onclick="select(0,2)">下一页</button>
    <button type="button" onclick="select(0,3)">末页</button>
</div>
<br><br><br>
<div align="center">
    <h3>添加</h3>
    name: <input name="typeName" id="typeName">
    <button type="button" onclick="tijiao()">提交</button>
</div>

</body>

<script type="text/javascript">
    $(function () {
        select(0);
    });
    
    function tijiao() {
        var typeName=$("#typeName").val();
        $.ajax({
            method:"post",
            url:"TypeInfos",
            data:{"typeName":typeName},
            success:function (re) {
                alert(re);
                var dangqian=$("#dangqian").html();
                select(dangqian-1);
            }
        });
        $("#typeName").val("");
    }


        function select (start,flag) {//flag 1为上一页2为下一页3为尾页
            var dangqian=$("#dangqian").html();
            if(flag==1){
                    start=dangqian-2;
            }else if (flag==2){
                start=dangqian;
            }else if(flag==3){
                start=$("#yigong").html()-1;
            }
            var url="TypeInfos?start="+start+"&size=5";
            $.get(
                url,
                function (re) {
                    $("#dangqian").html(re.number+1);
                    $("#yigong").html(re.totalPages);
                    var content=re.content;
                    var ttt;
                    if(content!=null){
                    $("tbody").html(" ");
                    for(var i in content){
                        $("tbody").append($("<tr>" +
                            "<td>"+content[i].typeId+"</td>" +
                            "<td>"+content[i].typeName+"</td>" +
                            "<td><button type='button' onclick=' edit ("+content[i].typeId+",this);'>编辑</button></td>" +
                            "<td><button type='button'  onclick='shan ("+content[i].typeId+");'>删除</button></td>" +
                            "</tr>"));
                    }
                    }
                }
            );
        }
        
        function edit(id,aa) {
            var typeName = prompt("请输入要修改的名字,原名字为:"+$(aa).parent().prev().html());
            if(typeName!=null){
                $.ajax({
                    method:"put",
                    url:"TypeInfos/"+id,
                    data:{"typeId":id,"typeName":typeName},
                    success:function (re) {
                        alert(re);
                        var dangqian=$("#dangqian").html();
                        select(dangqian-1);
                    }
                });
            }

        }
        
        function shan(id) {
            $.ajax({
                method:"delete",
                url:"TypeInfos/"+id,
                success:function (re) {
                    alert(re);
                    var dangqian=$("#dangqian").html();
                    select(dangqian-1);
                }
            });
        }





</script>
</html>
