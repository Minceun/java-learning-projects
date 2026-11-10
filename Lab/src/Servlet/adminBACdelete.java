package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.BACed;
import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class adminBACdelete
 */
@WebServlet("/adminBACdelete")
public class adminBACdelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入删除的函数！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String BACid=request.getParameter("id");
		BACed bac=parUser.selectBACById1(BACid);
		System.out.println("bac对象 "+bac);
		int count=parUser.deleteBAC1(bac);
		System.out.println("删除的count = "+count);
		//成功或者失败的重定向
		if(count==0)
		{//修改成功
			response.sendRedirect("/Lab/managerGrau");
			
		}
		else {
			response.sendRedirect("/Lab/managerGrau");
		}	
	}


}
