package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.JDBCUtils;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");		
		response.getWriter().print("注册成功！3秒后将跳转到登陆界面！");
		response.setHeader("Refresh", "3;URL=/FirstServlet/test/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html");
         request.setCharacterEncoding("utf-8"); 
          response.setCharacterEncoding("utf-8");
       
          String name=request.getParameter("username");
          String password=request.getParameter("userpwd");
 			System.out.println(name+","+password);

 			
 			Connection conn = null;
 			PreparedStatement stmt = null;
 			ResultSet rs = null;
 			try {
 			// 获得数据的连接
 			conn = JDBCUtils.getConnection();
 			// 获得Statement对象
 			String sql="insert  into users(name,password)";
             sql+=" values(?,?)";
 			stmt = conn.prepareStatement(sql);
             stmt.setString(1,name);
             stmt.setString(2,password);
             stmt.executeUpdate();
             System.out.println("success");
 			} catch (Exception e) {
 				e.printStackTrace();
 			} finally {
 				JDBCUtils.release(rs, stmt, conn);
 			}
         
         
         
         response.setContentType("text/html;charset=utf-8");		
  		response.getWriter().print("注册成功！3秒后将跳转到登陆界面！");
  		response.setHeader("Refresh", "3;URL=/FirstServlet/test/login.jsp");
 	}

}
