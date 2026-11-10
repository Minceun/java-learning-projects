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
 * Servlet implementation class manage_admin_add
 */
@WebServlet("/manage_admin_add")
public class manage_admin_add extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String id=request.getParameter("id");
		String num=request.getParameter("admin_num");
		String name=request.getParameter("admin_name");
		String psw=request.getParameter("admin_password");
		String status=request.getParameter("status");
		int s=Integer.parseInt(status);
		admin u=new admin(id,num,name,psw,s);
		//加入到数据库的用户表中
		System.out.println(u);
		int count=parUser.insertAdmin1(u);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			response.sendRedirect("admin_select");
			
		}
		else {
			response.sendRedirect("admin_select");
		}
	}

}
