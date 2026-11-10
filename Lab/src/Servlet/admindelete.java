package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.BACed;
import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class admindelete
 */
@WebServlet("/admindelete")
public class admindelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入删除的函数！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String adminID=request.getParameter("id");
		admin ad1=parUser.selectById1(adminID);
		System.out.println("user对象 "+ad1);
		int count=parUser.delete1(ad1);
		System.out.println("删除的count = "+count);
		//成功或者失败的重定向
		if(count==0)
		{//修改成功
			response.sendRedirect("/Lab/admin_select");
			
		}
		else {
			response.sendRedirect("/Lab/admin_select");
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
