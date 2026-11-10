package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.JDBCUtils;

@SuppressWarnings("serial")
public class myServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String proname = request.getParameter("username");
		String propassword = request.getParameter("password");
		//处理乱码
		String name = new String(proname.getBytes("ISO8859-1"),"utf-8");
		String password = new String(propassword.getBytes("ISO8859-1"),"utf-8");

		if(name.equals("admin")&&password.equals("124121")) {
			response.sendRedirect("/FirstServlet/test/admin_info.jsp");
			System.out.println("登录成功");
		}else if((name.equals("aaaaaa")&&password.equals("aaaaaa"))||(name.equals("bbbbbb")&&password.equals("bbbbbb"))) {
			response.sendRedirect("/FirstServlet/test/user_info.jsp");
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
			response.sendRedirect("/FirstServlet/test/login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8"); 
         response.setCharacterEncoding("utf-8");
      
         String name=request.getParameter("username");
         String password=request.getParameter("password");
			System.out.println(name+","+password);

			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			String sql = "SELECT * FROM users WHERE name='" + name +"' and password ='"+ password+"';";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			HttpSession session = request.getSession();
			while (rs.next()) {
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("password"));
					if(rs.getString("name").equals("admin")&&rs.getString("password").equals("124121")) {
						session.setAttribute("username", name);
						session.setAttribute("password", password);
						response.sendRedirect("/FirstServlet/test/users.jsp");
					}else {
						session.setAttribute("username", name);
						session.setAttribute("password", password);
						response.sendRedirect("/FirstServlet/test/welcome.jsp");
					}
			}
			response.sendRedirect("/FirstServlet/test/login.jsp");
            
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			

    }
}
