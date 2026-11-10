<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="/FirstServlet/test/css/log.css">
		<script type="text/javascript" src="/FirstServlet/test/js/login.js"></script>
		<title>登录</title>
	</head>
	<body>
		<div class ="content"><br />
			<div class="head">
				<h1>Login</h1>
			</div>
			<div class="form">
				<form action="/FirstServlet/myservlet" method="post" id="login" name="login" onsubmit="">
 				<span id="span01"></span>
 				<div class="in">
						<input type="text" id="username" name="username" placeholder="请输入姓名" onblur="CheckUserName()"/><br />
						<input type="password" id="password" name="password" placeholder="请输入密码"/><br />
					</div>
					<br />
					<div class="butt">
						<input type="submit" value="登 录" id="log"/>
					</div>
					<br />
				</form>
				<div class="butt">
					<input type="button" value="注 册" onclick="jump();">
				</div>
				<br>
			</div>
		</div>
	</body>
</html>
