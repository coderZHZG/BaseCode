<#--<@c.set var="ctx" value="${request.contextPath}" />-->
<#assign ctx=request.contextPath>
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
        <th>流程id(ProcessInstanceId)</th>
        <th>任务id(TaskId)</th>
        <th>任务名称(TaskName)</th>
        <th>提交人(apply)</th>
        <th>审批人(approve)</th>
       <#-- <th>处理人(Assignee)</th>-->
        <th>提交时间(CreateTime)</th>
        <th>流程图</th>
    </tr>
<#list actList as act>
<tr>
    <td>${act.processInstanceId}</td>
    <td>${act.taskId}</td>
    <td>${act.taskName}</td>
    <td>${act.apply}</td>
    <td>${act.approve}</td>
   <#-- <td>${act.assignee}</td>-->
    <td>${act.createTime?string('yyyy-MM-dd')}</td>
    <td><img style="width: 200px;height: 300px" src="${ctx}/act/getFlowImg/${act.processInstanceId}" alt="流程图" /></td>
</tr>
</#list>
</table>
<#--<h1>查询到的总人数：${count}</h1>-->
<#--<img style="width: 120px;height: 120px;" src="../image/1.jpg">-->
</body>
</html>
<script type="text/javascript" src="${ctx}/plugin/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
    })


</script>