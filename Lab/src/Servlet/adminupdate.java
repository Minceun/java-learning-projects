package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class adminupdate
 */
@WebServlet("/adminupdate")
public class adminupdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//查找到用户的id号
		String id=request.getParameter("id");
		admin ad1=parUser.selectById1(id);
		//将一个对象返回到页面上
		request.setAttribute("user", ad1);
		request.getRequestDispatcher("manage_admin_modify.jsp").forward(request, response);
		}

}
