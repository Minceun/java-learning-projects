<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="infor" content="width=device-width,initial-scale=1.0">
 		<link rel="stylesheet" href="/FirstServlet/test/css/log.css">
		<link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
		<title>完善信息</title>
		<script type="text/javascript">
		window.onload = function(){
/* 			alert("hhh");
 */			
		}
		</script>
	</head>
	<body>
		<%@ include file="head_admin.jsp" %>
	<%
		String s1 = (String)session.getAttribute("username");
		if(s1 != null){
 	        System.out.println("欢迎用户: " + s1);

		}else{
 	        System.out.println("您还没有进行登陆!");
 	       response.sendRedirect("/FirstServlet/test/login.jsp");

		}
	%>
	
	<%@page import ="java.io.IOException,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,
	java.sql.ResultSet,java.sql.SQLException,com.jdbc.JDBCUtils,javax.servlet.ServletException,
	javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>

	<% 		
		Connection conn = JDBCUtils.getConnection();
		String sql="select * from users";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
        System.out.println("success");
	%>
        <div class ="content"><br />
            <h1>用户名单</h1>   
            <table>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
            </tr>
            <% while(rs.next()){
            %>
            <tr>
            <td><%=rs.getString("id") %></td>
            <td><%=rs.getString("name") %></td>
             </tr>
            <%}	 
            %>

<%
			JDBCUtils.release(rs, stmt, conn);
	%>
        </table>
        </div>
        
	</body>
</html>
