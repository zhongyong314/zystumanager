<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function searchUser(){

		$("#dg").datagrid('load',{ 
			"stuname":$("#stuname").val(),
			"subjectname":$("#subjectname").val(),
			"age":$("#age").val()
		});
	}
</script>
</head>
<body style="margin: 1px">
<div id="tb">
 <div>
 学生姓名：<input type="text" id="stuname" name="id" class="easyui-validatebox" />
科目：<input type="text" id="subjectname" name="subjectname" class="easyui-validatebox" />
年龄：<input type="text" id="age" name="age" class="easyui-validatebox" />
 	<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 </div>
</div>
<table id="dg" title="学生管理" class="easyui-datagrid"
  fitColumns="true" pagination="true" rownumbers="true"
  url="${pageContext.request.contextPath}/stuInfo/getstuinfos.action" fit="true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="cb" checkbox="true" align="center"></th>
 		<th field="stuname" width="80" align="center">学生名</th>
 		<th field="age" width="80" align="center">年龄</th>
 		<th field="subjectname" width="50" align="center">学科</th>
 		<th field="score" width="50" align="center">分数</th>
 		<th field="remark" width="100" align="center">备注</th>
 	</tr>
 </thead>
</table>
<div>
版权所有
</div>
</body>
</html>