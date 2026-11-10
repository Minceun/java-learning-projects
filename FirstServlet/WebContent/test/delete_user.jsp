<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <meta name="infor" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="/FirstServlet/test/css/welcome.css">
        <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>

        <script type="text/javascript" src="/FirstServlet/test/js/welcome.js"></script>
        <link rel="stylesheet" href="/FirstServlet/test/css/menu.css">
        <title>welcome!</title>
        
        
        <%@ include file="head_admin.jsp" %>
	<%@page import ="java.io.IOException,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,
	java.sql.ResultSet,java.sql.SQLException,com.jdbc.JDBCUtils,javax.servlet.ServletException,
	javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>

        <script type="text/javascript">
        
        </script>
    </head>
    <style type="text/css">
            .modal.fade.in{
                top:90px;
            }
    </style>
	<body>
<%		String sql = "DELETE FROM users WHERE name='121212';";

		Connection conn = JDBCUtils.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		int num = stmt.executeUpdate();

        System.out.println("delete!");
	%>   
            <%
			JDBCUtils.release(stmt, conn);
	%>
	
       } 
      <div class ="content">
        <p style="color:white;">删除成功！</p>
    </div>
	</body>
</html>
