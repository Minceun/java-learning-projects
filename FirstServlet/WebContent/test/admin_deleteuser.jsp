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
        function insertAfter(newElement, targentElement) {
            var parent = targentElement.parentNode;
            if (parent.lastChild == targentElement) {
                parent.appendChild(newElement);
            } else {
                parent.insertBefore(newElement, targentElement.nextSibling)
            }
        }
        function save(obj){
            var $td = $(obj.parentElement);
            $(obj).attr("value",$(obj).val());
            var aft =$(obj).val();
            $td.html('<td style=\"border-color: transparent;\">&nbsp;&nbsp;&nbsp'+aft+'</td>');
        }
        function del(obj){	
    			var $td = $(obj.parentElement).prev().prev();
    			var name=$td.html();
            alert(name); 
            obj.parentElement.parentElement.parentElement.removeChild(obj.parentElement.parentElement);
        	window.location.href="/FirstServlet/test/delete_user.jsp";
          
        }
        function change(obj){
        		var $td = $(obj.parentElement);
            $td.prev().html("<input type='text' id='newname' onblur='save(this)'>");
        }
        </script>
    </head>
    <style type="text/css">
            .modal.fade.in{
                top:90px;
            }
    </style>
	<body>
        <div class ="content"><br />
            <h1 id="hh" class="text-muted">管理用户</h1><br>

<% 		
		Connection conn = JDBCUtils.getConnection();
		String sql="select * from users";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
        System.out.println("success");
	%>
	
            <table style="border=1px;" id="tb">
                <tr>
                    <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;用户ID&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;用户名&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td class="bigclassname">&nbsp;&nbsp;&nbsp;&nbsp;删除&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    
                </tr>
                <% while(rs.next()){
            %>
            <tr>
            <td><%=rs.getString("id") %></td>
            <td><%=rs.getString("name") %></td>
            <td><input type="button" value="修改" onclick="change(this);" /></td>
            <td><input type="button" value="删除" onclick="del(this);" /></td>
            
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
