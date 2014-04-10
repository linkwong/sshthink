<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function addUser(){
		var form = document.forms[0];
		form.action = "/sshthink/user/addUser";
		form.method="post";
		form.submit();
	}
</script>
  </head>
  
  <body>
<h1>添加用户</h1>
	<form action="" name="userForm">
		姓名：<input type="text" name="username"><br>
		年龄：<input type="text" name="password">
		<input type="button" value="添加" onclick="addUser()">
	</form>
    
  </body>
</html>
