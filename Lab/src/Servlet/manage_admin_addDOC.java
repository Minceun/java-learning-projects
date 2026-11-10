package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.DOCed;
import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class manage_admin_addDOC
 */
@WebServlet("/manage_admin_addDOC")
public class manage_admin_addDOC extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String DOCid=request.getParameter("DOCid");
		String DOCname=request.getParameter("DOCname");
		String DOCgender=request.getParameter("DOCgender");
		String DOCtele=request.getParameter("DOCtele");
		String DOCfield=request.getParameter("DOCfield");
		String DOCemail=request.getParameter("DOCemail");
		String DOCMes=request.getParameter("DOCMes");
		String DOCresult=request.getParameter("DOCresult");
		String DOCpatent=request.getParameter("DOCpatent");
		int status=Integer.parseInt(request.getParameter("status"));
		DOCed doc=new DOCed(DOCid, DOCname, DOCgender, DOCtele, DOCfield, DOCemail, DOCMes, DOCresult, DOCpatent, status);
		
		int count=parUser.insertDOC1(doc);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			response.sendRedirect("managerGrau");
			
		}
		else {
			response.sendRedirect("managerGrau");
		}
	}

}
