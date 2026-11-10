package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class adminmodify
 */
@WebServlet("/adminmodify")
public class adminmodify extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入修改的函数！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String userID=request.getParameter("id");
		String userNum=request.getParameter("admin_num");
		String username=request.getParameter("admin_name");
		String pwd=request.getParameter("admin_password");
		String status=request.getParameter("status");
		int s=Integer.parseInt(status);
		admin user=new admin(userID,userNum,username,pwd,s);
		//加入到数据库的用户表中
		System.out.println(user);
		int count=parUser.update1(user);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{//修改成功
			response.sendRedirect("/Lab/admin_select");
			
		}
		else {
			response.sendRedirect("/Lab/admin_select");
			
		}
	}

}
