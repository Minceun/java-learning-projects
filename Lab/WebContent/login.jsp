<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/labs/headAndTail/head.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="/Lab/css/log.css">
		<title>管理员</title>
	</head>
	<body class="layui-bg-gray">
	<div id="back">
		<div class ="content"><br />
			<div class="head">
				<h1>Login</h1>
			</div>
			<div class="form">
				<form action="/Lab/login" method="post" id="login" name="login" onsubmit="">
 				<span id="span01"></span>
 				<div class="in">
						<input type="text" id="username" name="admin_num" placeholder="请输入姓名"/><br />
						<input type="password" id="password" name="admin_password" placeholder="请输入密码"/><br />
					</div>
					<br />
					<div class="butt">
						<input type="submit" value="登 录" id="log"/>
					</div>
					<br />
				</form>
				<br>
			</div>
		</div>
		</div>
	</body>
</html>