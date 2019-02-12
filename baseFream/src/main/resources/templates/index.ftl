<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8"/>
    <title></title>
    <style>
        table {
            width: 50%;
            font-size: .938em;
            border-collapse: collapse;/*边框合并*/
        }
        th {
            text-align: left;
            padding: .5em .5em;
            font-weight: bold;
            background: #66677c;color: #fff;
        }

        td {
            padding: .5em .5em;
            border-bottom: solid 1px #ccc;
        }

        table,table tr th, table tr td { border:1px solid #0094ff; }/*设置边框*/
    </style>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Phone</th>
    </tr>
<#list userList as user>
<tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.phone}</td>
</tr>
</#list>
</table>
<h1>查询到的总人数：${count}</h1>
<#--<img style="width: 120px;height: 120px;" src="../image/1.jpg">-->
</body>
</html>
<script type="text/javascript" src="../plugin/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">


</script>