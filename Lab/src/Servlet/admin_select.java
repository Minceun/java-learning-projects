package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class admin_select
 */
@WebServlet("/admin_select")
public class admin_select extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//搜索关键字
		String keywordString=request.getParameter("keywords");

		
		//获取所有用户
		ArrayList<admin> list=parUser.selectAdmin1(keywordString);
		//放到请求对象中
		request.setAttribute("userlist", list);
		request.getRequestDispatcher("admin_show.jsp").forward(request, response);
		
		
		
	}

}
