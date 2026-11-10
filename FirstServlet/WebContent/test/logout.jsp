<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注销</title>
<script type="text/javascript">
	window.onload=function(){
		/* session.invalidate("username");
		session.invalidate("password");

		sessionStorage.removeItem("username");
		sessionStorage.removeItem("password");*/
		window.location.href = "login.jsp"; 
		alert("您已注销！");
	}
</script>
</head>
<body>
<%@page import ="java.io.IOException,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,
	java.sql.ResultSet,java.sql.SQLException,com.jdbc.JDBCUtils,javax.servlet.ServletException,
	javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpSession"%>
<% 	request.getSession(); 
	session.invalidate(); %>
</body>
</html>